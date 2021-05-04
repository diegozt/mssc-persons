package com.dazt.msscpersons.mapper;

import com.dazt.msscpersons.dto.BaseDTO;
import com.dazt.msscpersons.model.Person;
import org.mapstruct.*;
import org.springframework.stereotype.Controller;

abstract class TrackingDataMapper {

    @AfterMapping
    void setAuditValues(Person person, @MappingTarget final BaseDTO.BaseDTOBuilder dto) {
        dto.environmentPort("125");
    }

}
