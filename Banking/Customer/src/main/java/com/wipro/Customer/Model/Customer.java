package com.wipro.Customer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity@Data@AllArgsConstructor@RequiredArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private Long customerId;
	private String customerName;
	private String dateOfBirth;
	private String panNo;
	private Long phoneNumber;
	private String emailId;
}
