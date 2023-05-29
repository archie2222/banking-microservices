package com.banking.ewallet.repository;

import com.banking.ewallet.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Optional<Customer> findFirstByNationalId(String nationalId);
}
