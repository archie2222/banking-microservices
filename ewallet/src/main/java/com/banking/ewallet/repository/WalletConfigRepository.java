package com.banking.ewallet.repository;

import com.banking.ewallet.model.WalletConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletConfigRepository extends JpaRepository<WalletConfig,String> {
    List<WalletConfig> findAll();
}
