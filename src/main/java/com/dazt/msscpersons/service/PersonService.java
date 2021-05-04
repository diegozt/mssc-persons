package com.dazt.msscpersons.service;

import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonDTO> findByName(Optional<String> firstName, Optional<String> secondName, Optional<String> lastName, Optional<String> secondLastName);

    List<PersonDTO> findAll();

}
