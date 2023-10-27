package com.wipro.Account.Repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Account.Model.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement,Long>{
	public Statement[] findByDateBetweenAndAccountId(Date fromDate, Date toDate,Long accountId);
}
