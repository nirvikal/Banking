package com.wipro.Account.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue
	private Long accountId;
	private Long customerId;
	private String accountType;
	private Double balance;
}
