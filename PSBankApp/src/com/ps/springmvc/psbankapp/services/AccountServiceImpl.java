package com.ps.springmvc.psbankapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.springmvc.psbankapp.dao.AccountDAO;
import com.ps.springmvc.psbankapp.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountDao;	
	@Override
	@Transactional
	public boolean saveAccount(Account account) {			
		return accountDao.saveAccount(account);
	}
	
	
	
	@Override
	@Transactional
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return accountDao.getAccounts();
	}



	@Override
	@Transactional
	public Account getAccount(Integer accountNo) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(accountNo);
	}



	@Override
	@Transactional
	public boolean deleteAccount(Integer accountNo) {
		// TODO Auto-generated method stub
		return accountDao.deleteAccount(accountNo);
	}



	@Override
	@Transactional
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.updateAccount(account);
	}

}
