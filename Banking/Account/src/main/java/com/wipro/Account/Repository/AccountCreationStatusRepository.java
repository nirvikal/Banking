package com.wipro.Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Account.Model.AccountCreationStatus;

@Repository
public interface AccountCreationStatusRepository extends JpaRepository<AccountCreationStatus,Long>{

}
