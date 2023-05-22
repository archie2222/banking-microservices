package com.banking.ewallet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AuditableBase{
    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String number;
    private String currency;
    @ManyToOne
    @JsonBackReference("customer")
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
