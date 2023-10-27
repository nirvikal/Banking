package com.wipro.Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Account.Model.TransactionStatus;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus,Long>{

}
