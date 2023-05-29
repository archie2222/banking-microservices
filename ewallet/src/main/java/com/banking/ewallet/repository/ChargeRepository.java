package com.banking.ewallet.repository;

import com.banking.ewallet.model.Account;
import com.banking.ewallet.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository<Charge,String> {
}
