package com.wipro.Account.Service;

import java.sql.Date;

import com.wipro.Account.Model.Account;
import com.wipro.Account.Model.AccountCreationStatus;
import com.wipro.Account.Model.Statement;
import com.wipro.Account.Model.TransactionStatus;

public interface AccountService {
	public AccountCreationStatus createAccount(Long customerId);
	public Account[] getCustomerAccounts(Long customerId);
	public Account getAccount(Long accountId);
	public Statement[] getAccountStatement(Long accountId,Date fromDate,Date toDate);
	public TransactionStatus deposit(Long accountId,Double amount);
	public TransactionStatus withdraw(Long accountId,Double amount);
	public Account saveAccount(Account account);
}
