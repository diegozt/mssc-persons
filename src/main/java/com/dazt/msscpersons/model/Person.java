package com.dazt.msscpersons.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Person extends BaseModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false )
    public UUID personId;

    private String firstName;

    private String secondName;

    private String firstLastName;

    private String secondLastName;

    private String documentType;

    private String documentNumber;

    @OneToOne
    private PersonGeoLocation geoLocation;

}
