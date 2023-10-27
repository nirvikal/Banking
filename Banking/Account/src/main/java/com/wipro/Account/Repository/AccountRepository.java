package com.wipro.Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Account.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
	public Account[] findAccountByCustomerId(Long customerId);
}
