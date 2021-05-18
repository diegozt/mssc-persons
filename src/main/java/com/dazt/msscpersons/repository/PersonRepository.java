package com.dazt.msscpersons.repository;

import com.dazt.msscpersons.dto.type.DocumentType;
import com.dazt.msscpersons.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    List<Person> findByFirstNameIgnoreCaseAndSecondNameIgnoreCaseAndFirstLastNameIgnoreCaseAndSecondLastNameIgnoreCase(Optional<String> firstName, Optional<String> secondName,
                                                                               Optional<String> lastName, Optional<String> secondLastName);

    @Transactional
    @Modifying
    @Query("update Person p set p.firstName = ?1, p.secondName = ?2, p.firstLastName = ?3, p.secondLastName = ?4, p.documentType = ?5, p.documentNumber = ?6 where p.id = ?7" )
    void updatePerson(String firstName, String secondName, String firstLastName, String secondLastName, String documentType, String documentNumber, UUID id);
}
