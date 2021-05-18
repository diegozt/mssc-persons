package com.dazt.msscpersons.service.impl;

import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.mapper.PersonGeolocationMapper;
import com.dazt.msscpersons.mapper.PersonMapper;
import com.dazt.msscpersons.model.Person;
import com.dazt.msscpersons.model.PersonGeoLocation;
import com.dazt.msscpersons.repository.PersonGeolocationRepository;
import com.dazt.msscpersons.repository.PersonRepository;
import com.dazt.msscpersons.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonGeolocationRepository personGeolocationRepository;

    private final PersonMapper personMapper;

    private final PersonGeolocationMapper personGeolocationMapper;

    @Override
    public List<PersonDTO> findByName(Optional<String> firstName, Optional<String> secondName, Optional<String> lastName, Optional<String> secondLastName) {
        List<PersonDTO> listPersonDTO = new ArrayList<>();
        List<Person> listPerson = personRepository.findByFirstNameIgnoreCaseAndSecondNameIgnoreCaseAndFirstLastNameIgnoreCaseAndSecondLastNameIgnoreCase(
                firstName, secondName, lastName, secondName);
        if(listPerson != null) {
            listPerson.stream().forEach(person -> {
                listPersonDTO.add(personMapper.entityToDto(person));
            });
        }
        return listPersonDTO;
    }

    @Override
    public List<PersonDTO> findAll() {
        List<PersonDTO> listPersonReturn = new ArrayList<>();
        List<Person> listPerson = personRepository.findAll();
        if(listPerson != null) {
            listPerson.stream().forEach(person -> {
                listPersonReturn.add(personMapper.entityToDto(person));
            });
        }
        return listPersonReturn;
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        PersonGeoLocation personGeoLocation = personGeolocationMapper.dtoToEntity(personDTO.getGeolocationDTO());
        PersonGeoLocation createdPersonGeoLocation = personGeolocationRepository.save(personGeoLocation);

        Person person = personMapper.dtoToEntity(personDTO);
        person.setGeoLocation(createdPersonGeoLocation);

        return personMapper.entityToDto(personRepository.save(person));
    }

    @Override
    public PersonDTO updatePerson(UUID personId, PersonDTO personDTO) {
        Optional<Person> optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isPresent()) {
            Person person = personMapper.dtoToEntity(personDTO);
            Person updatedPerson = personRepository.save(person);
            log.debug("Saved Beer Order: " + updatedPerson.getPersonId());
            return personMapper.entityToDto(updatedPerson);
        }

        throw new RuntimeException("Person to be updated was not found");
    }

    @Override
    public void deletePerson(UUID personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isPresent()) {
            personRepository.deleteById(personId);
            log.debug("Person deleted: " + personId);
        } else {
            throw new RuntimeException("Person to be deleted was not found");
        }
    }


}
