package com.dazt.msscpersons.service.impl;

import com.dazt.msscpersons.model.Person;
import com.dazt.msscpersons.repository.PersonRepository;
import com.dazt.msscpersons.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }
}
