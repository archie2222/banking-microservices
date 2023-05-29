package com.banking.ewallet.repository;

import com.banking.ewallet.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,String> {
}
