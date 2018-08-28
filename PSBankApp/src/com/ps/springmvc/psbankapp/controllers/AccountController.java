package com.ps.springmvc.psbankapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps.springmvc.psbankapp.model.Account;
import com.ps.springmvc.psbankapp.services.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String viewAccount(Model model) {
		
		
		
		return "findAccount";
	}
	
	
	@RequestMapping("/")
	public String showHomePage() {	
		return "index";
	}
	
	@RequestMapping("/new")
	public String newAccount(Model model) {
		model.addAttribute("account", new Account());
		return "account-form";
	}
	
	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	}
	
	@RequestMapping(value="/saveAccount", method=RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result, Model model) {
		
	/*	String acNo = request.getParameter("accountNo");
		String customerName = request.getParameter("accountHolderName");
		String balance = request.getParameter("balance");
	*/	
/*		model.addAttribute("accountNumber", acNo);
		model.addAttribute("accountHolderName", customerName);
		model.addAttribute("balance", balance);
*/
/*		Account account = new Account();
		account.setAccountNo(Integer.parseInt(acNo));
		account.setAccountHolderName(customerName);
		account.setBalance(Integer.parseInt(balance));
*/		
	/*	model.addAttribute("account", account);
	*/	
		
/*		if(result.hasErrors()) {
			return "account-form";		}
		else
		{
			accountService.saveAccount(account);
			return "redirect:/list";
		}
*/	
		if(result.hasErrors()) {
			return "account-form";
		}
		else {
			
			String message = "";
			boolean flag = true;
			
			try {
				flag = accountService.saveAccount(account);
			}
			catch(Exception ex) {
				message = ex.getMessage();
				flag = false;
			}
			if (!flag) {
				model.addAttribute("message", message);
				return "account-form";
			}
			model.addAttribute("account", account);
			return "redirect:/list";
		}
	
	}
	
	
	@RequestMapping(value="/updateAccount", method=RequestMethod.POST)
	public String updateAccount(@Valid @ModelAttribute("account") Account account, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "update-form";
		}
		else {
			
			String message = "";
			boolean flag = true;
			
			try {
				flag = accountService.updateAccount(account);
			}
			catch(Exception ex) {
				message = ex.getMessage();
				flag = false;
			}
			if (!flag) {
				model.addAttribute("message", message);
				return "update-form";
			}
			model.addAttribute("account", account);
			return "redirect:/list";
		}

	}
	
	@GetMapping("/list")
	public String listAccounts(Model model) {
		
		List<Account> accounts = accountService.getAccounts();
		model.addAttribute("accounts", accounts);
		
		/*Code to retrieve the username from the previous page starts here*/
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		
		/*Code to retrieve the username from the previous page ends here*/
		
		return "listAccounts";
	}
	
	@GetMapping("/edit")
	public String updateAccounts(@RequestParam("accountNo") int accountNo, Model model) {
		
		Account account = accountService.getAccount(new Integer(accountNo));
		model.addAttribute("account", account);
		return "update-form";
	}

	@GetMapping("/delete")
	public String delteAccounts(@RequestParam("accountNo") int accountNo, Model model) {
		
		accountService.deleteAccount(accountNo);
		return "redirect:/list";
	}
	
	
}
