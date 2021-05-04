package com.dazt.msscpersons.repository;

import com.dazt.msscpersons.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    List<Person> findByFirstNameIgnoreCaseAndSecondNameIgnoreCaseAndFirstLastNameIgnoreCaseAndSecondLastNameIgnoreCase(Optional<String> firstName, Optional<String> secondName,
                                                                               Optional<String> lastName, Optional<String> secondLastName);

}
