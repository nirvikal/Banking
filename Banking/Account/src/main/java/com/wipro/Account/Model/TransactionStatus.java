package com.wipro.Account.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionStatus {
	@Id
	private Long accountId;
	private String message;
	private Double sourceBalance;
	private Double destinationBalance;
}
