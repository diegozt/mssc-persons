package com.dazt.msscpersons.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    @Version
    private Long version;

    @LastModifiedDate
    protected Timestamp lastModifiedDate;

    @LastModifiedBy
    protected String lastModifiedUser;

    @CreatedDate
    @Column(updatable = false)
    protected Timestamp creationDate;

    @CreatedBy
    @Column(updatable = false)
    protected String creationUser;

}
