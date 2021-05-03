package com.dazt.msscpersons.mapper;

import com.dazt.msscpersons.dto.GeolocationDTO;
import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.mapper.decorator.PersonMapperDecorator;
import com.dazt.msscpersons.model.Person;
import com.dazt.msscpersons.model.PersonGeoLocation;
import org.mapstruct.*;

@Mapper(uses = {
        UUIDMapper.class,
        DateMapper.class
})
//@DecoratedWith(PersonMapperDecorator.class)
public interface PersonMapper {

    @Mapping(target = "geoLocation", source = "geolocationDTO")
    @Mapping(target = "personId", source = "id")
    @Mapping(target = "lastModifiedUser", source = "lastUserUpdate")
    @Mapping(target = "lastModifiedDate", source = "lastDateUpdate")
    @Mapping(target = "creationUser", source = "userCreated")
    @Mapping(target = "creationDate", source = "createdDate")
    Person dtoToEntity(PersonDTO personDTO);

    @InheritInverseConfiguration
    PersonDTO entityToDto(Person person);

    PersonGeoLocation geoLocationDtoToPersonGeoLocation(GeolocationDTO geolocationDTO);

    GeolocationDTO personGeoLocationToGeoLocationDto(PersonGeoLocation personGeoLocation);

}
