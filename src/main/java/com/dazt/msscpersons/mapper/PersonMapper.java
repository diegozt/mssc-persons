package com.dazt.msscpersons.mapper;

import com.dazt.msscpersons.dto.GeolocationDTO;
import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.model.Person;
import com.dazt.msscpersons.model.PersonGeoLocation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        UUIDMapper.class,
        DateMapper.class,
        TrackingDataMapper.class
})
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "geoLocation", source = "geolocationDTO")
    @Mapping(target = "personId", source = "id")
    @Mapping(target = "lastModifiedUser", source = "lastUserUpdate")
    @Mapping(target = "lastModifiedDate", source = "lastDateUpdate")
    @Mapping(target = "creationUser", source = "userCreated")
    @Mapping(target = "creationDate", source = "createdDate")
    Person dtoToEntity(PersonDTO personDTO);

    @InheritInverseConfiguration
    PersonDTO entityToDto(Person person);

    @Mapping(target = "personGeoLocationId", source = "id")
    PersonGeoLocation geoLocationDtoToPersonGeoLocation(GeolocationDTO geolocationDTO);

    @InheritInverseConfiguration
    GeolocationDTO personGeoLocationToGeoLocationDto(PersonGeoLocation personGeoLocation);

}
