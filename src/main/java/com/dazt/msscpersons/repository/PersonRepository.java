package com.dazt.msscpersons.repository;

import com.dazt.msscpersons.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Person findByFirstName(String firstName);

}
