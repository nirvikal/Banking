package com.wipro.Transactions.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionStatus {
	private Long accountId;
	private String message;
	private Double sourceBalance;
	private Double destinationBalance;
}
