package com.dazt.msscpersons.mapper;

import com.dazt.msscpersons.dto.GeolocationDTO;
import com.dazt.msscpersons.dto.PersonDTO;
import com.dazt.msscpersons.model.Person;
import com.dazt.msscpersons.model.PersonGeoLocation;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        UUIDMapper.class,
})
public interface PersonGeolocationMapper {

    PersonGeolocationMapper INSTANCE = Mappers.getMapper(PersonGeolocationMapper.class);

    @Mapping(target = "personGeoLocationId", source = "id")
    PersonGeoLocation dtoToEntity(GeolocationDTO geolocationDTO);

    @InheritInverseConfiguration
    GeolocationDTO entityToDto(PersonGeoLocation personGeoLocation);

}
