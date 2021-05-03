package com.dazt.msscpersons.mapper.decorator;

import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.mapper.DateMapper;
import com.dazt.msscpersons.mapper.PersonMapper;
import com.dazt.msscpersons.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.UUID;

public abstract class PersonMapperDecorator implements PersonMapper {

    @Autowired
    @Qualifier("delegate")
    private final PersonMapper delegate;

    private final DateMapper dateMapper;


    public PersonMapperDecorator(PersonMapper delegate, DateMapper dateMapper) {
        this.delegate = delegate;
        this.dateMapper = dateMapper;
    }

    @Override
    public Person dtoToEntity(PersonDTO personDTO) {
        Person person = delegate.dtoToEntity(personDTO);
        person.setPersonId(UUID.fromString(personDTO.getId()));
        person.setLastModifiedUser(personDTO.getLastUserUpdate());
        person.setLastModifiedDate(dateMapper.asTimestamp(personDTO.getLastDateUpdate()));
        person.setCreationUser(personDTO.getUserCreated());
        person.setCreationDate(dateMapper.asTimestamp(personDTO.getCreatedDate()));
        return person;
    }

    @Override
    public PersonDTO entityToDto(Person person) {
        PersonDTO personDTO = delegate.entityToDto(person);
        personDTO.setId(person.getPersonId().toString());
        personDTO.setCreatedDate(dateMapper.asOffsetDateTime(person.getCreationDate()));
        personDTO.setUserCreated(person.getCreationUser());
        personDTO.setLastDateUpdate(dateMapper.asOffsetDateTime(person.getLastModifiedDate()));
        personDTO.setLastUserUpdate(person.getLastModifiedUser());
        return personDTO;
    }

}
