package com.ps.springmvc.psbankapp.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.springmvc.psbankapp.validations.PSCode;

public class Account {
	
	@NotNull(message="Account # can't be blank")
	private Integer accountNo;
	
	@NotNull(message="Account Holder Name can't be blank")
	@Size(min=2, max=50, message="Invalid length for Account Holder Name")
	@Pattern(regexp="[A-Za-z(\\s)]+", message="Invalid Account Holder Name")
	private String accountHolderName;
	
	@NotNull(message="Balance amount is required")
	@Min(value=5000, message="Minimum balance must not be less than 5000")
	private Integer balance;
	
	@NotNull(message="Account Type can't be Null")
	private String accountType;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message="Date of Birth cant be Null")
	@Past(message="Account cant be created for a person not born")
	private Date dateOfBirth;
	
	@NotNull(message="PS Code is required")
	@PSCode(value="PSUSA", message="PS Code should start with PSUSA")
	private String psCode;
	
	public Account() {
		
		}
	
	public Account(Integer accNo, String holderName, Integer balance) {
		
		this.accountNo = accNo;
		this.accountHolderName = holderName;
		this.balance = balance;
		
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	
}
