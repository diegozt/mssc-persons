package com.dazt.msscpersons.service.impl;

import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.mapper.PersonMapper;
import com.dazt.msscpersons.model.Person;
import com.dazt.msscpersons.repository.PersonRepository;
import com.dazt.msscpersons.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

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


}
