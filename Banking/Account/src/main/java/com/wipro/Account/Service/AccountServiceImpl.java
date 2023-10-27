package com.wipro.Account.Service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Account.Model.Account;
import com.wipro.Account.Model.AccountCreationStatus;
import com.wipro.Account.Model.Statement;
import com.wipro.Account.Model.TransactionStatus;
import com.wipro.Account.Repository.AccountCreationStatusRepository;
import com.wipro.Account.Repository.AccountRepository;
import com.wipro.Account.Repository.StatementRepository;
import com.wipro.Account.Repository.TransactionStatusRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountCreationStatusRepository accountStatusRepo;
	@Autowired
	AccountRepository accountRepo;
	@Autowired
	StatementRepository stmtRepo;
	@Autowired
	TransactionStatusRepository transRepo;

	@Override
	public AccountCreationStatus createAccount(Long customerId) {
		Account saving = saveAccount(new Account(null,customerId,"Savings",0.00));
		saveAccount(saving);
		accountStatusRepo.save(new AccountCreationStatus(saving.getAccountId(),"Savings account created Successfully for the CustomerId"));
		Account current = saveAccount(new Account(null,customerId,"Current",0.00));
		saveAccount(current);
		return accountStatusRepo.save(new AccountCreationStatus(current.getAccountId(),"Current account created Successfully for the CustomerId"));
	}

	@Override
	public Account[] getCustomerAccounts(Long customerId) {
		return accountRepo.findAccountByCustomerId(customerId);
	}

	@Override
	public Account getAccount(Long accountId) {
		return accountRepo.findById(accountId).get();
	}

	@Override
	public Statement getAccountStatement(Long accountId, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionStatus deposit(Long accountId, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionStatus withdraw(Long accountId, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Account saveAccount(String accountType,Long customerId,Double balance) {
//		return accountRepo.save(null)
//	}
	
	@Override
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

}
