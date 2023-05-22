package com.banking.ewallet.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableBase {
    @CreatedBy
    protected String createdBy;
    @CreatedDate
    protected ZonedDateTime createdDate;
    @LastModifiedBy
    protected String lastModifiedBy;
    @LastModifiedDate
    protected ZonedDateTime lastModifiedDate;
}
