package com.dazt.msscpersons.mapper;

import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.mapper.decorator.PersonMapperDecorator;
import com.dazt.msscpersons.model.Person;
import org.mapstruct.*;

@Mapper(
    uses = {
        DateMapper.class,
        UUIDMapper.class
    })
//@DecoratedWith(PersonMapperDecorator.class)
public interface PersonMapper {

    Person dtoToEntity(PersonDTO personDTO);

    PersonDTO entityToDto(Person person);

}
