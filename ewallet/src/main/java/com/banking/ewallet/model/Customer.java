package com.banking.ewallet.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    protected String id;
    @Column(
            nullable = false
    )
    protected ZonedDateTime created;
    protected ZonedDateTime deleted;
    @Column(
            nullable = false
    )
    protected ZonedDateTime updated;
    private String name;
    private String surname;
    private String email;
    private String branch;
    private String designation;
    private String mobile;
}
