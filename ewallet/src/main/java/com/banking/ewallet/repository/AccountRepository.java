package com.banking.ewallet.repository;

import com.banking.ewallet.model.Account;
import com.banking.ewallet.model.AccountType;
import com.banking.ewallet.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    List<Account> findByAccountTypeAndCustomer(AccountType accountType, Customer customer);
}
