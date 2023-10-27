package com.wipro.Transactions.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {
	private Long accountId;
	private Long customerId;
	private String accountType;
	private Double balance;
}
