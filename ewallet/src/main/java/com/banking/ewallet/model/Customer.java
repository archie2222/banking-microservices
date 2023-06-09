package com.banking.ewallet.model;


import com.banking.ewallet.util.MapToJsonDataAttributeConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "customer")
public class Customer extends AuditableBase {
    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    private String surname;
    private String email;
    private String designation;
    private String msisdn;
    private LocalDate dob;
    private String status;
    private String nationalId;
    private String title;
    private String address;
    @JsonManagedReference("customer")
    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts = new HashSet<>(0);
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    @Column
    @Convert(
            converter = MapToJsonDataAttributeConverter.class
    )
    private Map<String, Object> structureData = new LinkedHashMap();
}
