package com.dazt.msscpersons.controller;

import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.mapper.PersonMapper;

import com.dazt.msscpersons.service.PersonService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonMapper personMapper;

    private final PersonService personService;

    @GetMapping("/mssc-persons/name/{firstName}")
    public PersonDTO retrievePerson(@PathVariable String firstName) {
        PersonDTO dto = personMapper.entityToDto(personService.findByFirstName(firstName));
        return dto;
    }

}
