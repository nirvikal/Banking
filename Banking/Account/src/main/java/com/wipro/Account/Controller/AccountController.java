package com.wipro.Account.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.Account.Model.Account;
import com.wipro.Account.Model.AccountCreationStatus;
import com.wipro.Account.Model.Statement;
import com.wipro.Account.Model.TransactionStatus;
import com.wipro.Account.Service.AccountServiceImpl;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountServiceImpl service;
	
	@PostMapping("/createAccount")
	public AccountCreationStatus accountCreationStatus(@RequestBody Long customerId) {
		return service.createAccount(customerId);
	}
	
	@GetMapping("/getCustomerAccounts")
	public Account[] getCustomerAccounts(@RequestParam(value="customerId") Long customerId) {
		return service.getCustomerAccounts(customerId);
		
	}
	
	@GetMapping("/getAccount")
	public Account getAccount(@RequestParam(value="accountId") Long accountId) {
		return service.getAccount(accountId);
		
	}
	
	@GetMapping("/getAccountStatement")
	public Statement getAccountStatement(@RequestParam(value="accountId") Long accountId,@RequestParam(value="fromDate") Date fromDate,
			@RequestParam(value="toDate") Date toDate) {
				return service.getAccountStatement(accountId, fromDate, toDate);
		
	}
	
	@PostMapping("/deposit")
	public TransactionStatus deposit(@RequestParam(value="accountId") Long accountId,@RequestParam(value="amount") Double amount) {
		return service.deposit(accountId, amount);
		
	}
	
	@PostMapping("/withdraw")
	public TransactionStatus withdraw(@RequestParam(value="accountId") Long accountId,@RequestParam(value="amount") Double amount) {
		return service.withdraw(accountId, amount);
		
	}
}
