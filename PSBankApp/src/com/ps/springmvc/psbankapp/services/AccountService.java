package com.ps.springmvc.psbankapp.services;

import java.util.List;

import javax.validation.Valid;

import com.ps.springmvc.psbankapp.model.Account;

public interface AccountService {
	
	public boolean saveAccount(Account account);
	
	public List<Account> getAccounts();

	public Account getAccount(Integer accountNo);

	public boolean deleteAccount(Integer accountNo);

	public boolean updateAccount(Account account);
}
