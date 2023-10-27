package com.wipro.Account.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statement {
	@Id
	@GeneratedValue
	private Long slNo;
	private Long accountId;
	private Date date;
	private String narration;
	private String cheq_Refno;
	private Date valueDate;
	private Double withdrawal;
	private Double deposit;
	private Double closingBalance;
}
