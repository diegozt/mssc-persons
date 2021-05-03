package com.dazt.msscpersons.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class GeolocationDTO {

    @NotEmpty
    @Max(value = 50, message = "{address} must not be more than 50 characters.")
    private String address;

    @Max(value = 50, message = "{district} must not be more than 50 characters.")
    private String district;

    @Max(value = 50, message = "{department} must not be more than 50 characters.")
    private String department;

    @NotEmpty
    @Max(value = 50, message = "{country} must not be more than 50 characters.")
    private String country;

}
