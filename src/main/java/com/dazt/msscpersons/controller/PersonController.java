package com.dazt.msscpersons.controller;

import com.dazt.msscpersons.dto.PersonDTO;

import com.dazt.msscpersons.service.PersonService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @Autowired
    Environment environment;

    @GetMapping(
            value = {"/mssc-persons/names/{firstName}/{secondName}/{lastName}/{secondLastName}",
                    "/mssc-persons/names/{firstName}/{lastName}/"
                    })
    public List<PersonDTO> retrieveListPersonByFullName(
            @PathVariable(name = "firstName", required = false) Optional<String> firstName,
            @PathVariable(name = "secondName", required = false) Optional<String> secondName,
            @PathVariable(name = "lastName", required = false) Optional<String> lastName,
            @PathVariable(name = "secondLastName", required = false) Optional<String> secondLastName
            ) {

        List<PersonDTO> lstReturn = personService.findByName(firstName, secondName, lastName, secondLastName);
        //TODO Pending to set the mmssc port in a generic class, not in the Controller.
        lstReturn.stream().forEach(personObj -> {
            personObj.setEnvironmentPort(environment.getProperty("server.port"));
        });
        return lstReturn;
    }

    @GetMapping("/mssc-persons/all/")
    public List<PersonDTO> retrievePerson() {
        List<PersonDTO> lstReturn = personService.findAll();
        //TODO Pending to set the mmssc port in a generic class, not in the Controller.
        lstReturn.stream().forEach(personObj -> {
            personObj.setEnvironmentPort(environment.getProperty("server.port"));
        });
        return lstReturn;
    }

    @PostMapping("/mssc-persons")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @PutMapping("/mssc-persons/{personId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePerson(@RequestBody PersonDTO personDTO, @PathVariable(name = "personId") UUID personId){
        personService.updatePerson(personId, personDTO);
    }

    @DeleteMapping("/mssc-persons/delete/{personId}")
    public void deletePerson(@PathVariable(name = "personId") UUID personId) {
        personService.deletePerson(personId);
    }

}
