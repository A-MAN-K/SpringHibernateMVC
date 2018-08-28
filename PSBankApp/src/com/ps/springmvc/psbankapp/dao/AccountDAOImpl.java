package com.ps.springmvc.psbankapp.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.springmvc.psbankapp.entity.AccountEntity;
import com.ps.springmvc.psbankapp.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveAccount(Account account) { 
		
		boolean saveFlag = true;
		
		AccountEntity accountEntity  = new AccountEntity();
		accountEntity.setAccNo(account.getAccountNo());
		accountEntity.setAccountHolderName(account.getAccountHolderName());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountType(account.getAccountType());
		accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setPsCode(account.getPsCode());
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
		    currentSession.save(accountEntity);
			// currentSession.saveOrUpdate(accountEntity);
		}
		catch(Exception e) {
			e.printStackTrace();
			saveFlag = false;	
		}
		return saveFlag;
	}

	@Override
	public List<Account> getAccounts() {
		
		List<Account> list = new ArrayList<Account>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Query<AccountEntity> query = session.createQuery("From AccountEntity", AccountEntity.class);
			List<AccountEntity> accounts = query.getResultList();
			
			for(AccountEntity accountEntity : accounts) {
				
				Account account = new Account();
				account.setAccountNo(accountEntity.getAccNo());
				account.setAccountHolderName(accountEntity.getAccountHolderName());
				account.setBalance(accountEntity.getBalance());
				account.setAccountType(accountEntity.getAccountType());
				account.setDateOfBirth(accountEntity.getDateOfBirth());
				account.setPsCode(accountEntity.getPsCode());
				
				list.add(account);
				
			}
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Account getAccount(Integer accountNo) {

		Account account = new Account();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			// This is how we load a single record from the database.
		//	AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountNo);
		//  The session.load method hits the proxy and does not hit the real database.	
			
			AccountEntity accountEntity = (AccountEntity) session.get(AccountEntity.class, accountNo);
			
			if(accountEntity == null) {
				
				return null;
			}
			
			account.setAccountNo(accountEntity.getAccNo());
			account.setAccountHolderName(accountEntity.getAccountHolderName());
			account.setBalance(accountEntity.getBalance());
			account.setAccountType(accountEntity.getAccountType());
			account.setDateOfBirth(accountEntity.getDateOfBirth());
			account.setPsCode(accountEntity.getPsCode());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public boolean deleteAccount(Integer accountNo) {
		// TODO Auto-generated method stub
		boolean deleteFlag = true;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity)session.load(AccountEntity.class, accountNo);
			session.delete(accountEntity);
		}
		catch(Exception e) {
			e.printStackTrace();
			deleteFlag = false;
		}
		return deleteFlag;
	}

	@Override
	public boolean updateAccount(Account account) {
		boolean saveFlag = true;
		
		AccountEntity accountEntity  = new AccountEntity();
		accountEntity.setAccNo(account.getAccountNo());
		accountEntity.setAccountHolderName(account.getAccountHolderName());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountType(account.getAccountType());
		accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setPsCode(account.getPsCode());
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
		    //currentSession.save(accountEntity);
			 currentSession.update(accountEntity);
		}
		catch(Exception e) {
			e.printStackTrace();
			saveFlag = false;	
		}
		return saveFlag;

	}

}
