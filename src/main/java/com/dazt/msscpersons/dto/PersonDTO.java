package com.dazt.msscpersons.dto;

import com.dazt.msscpersons.DocumentType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class PersonDTO extends BaseDTO {

    @NotEmpty
    @Size(min = 1, max = 200,
            message = "${firstName} length must be between 1 and 200 characters.")
    private String firstName;

    @Size(min = 1, max = 200,
            message = "${secondName} length must be between 1 and 200 characters.")
    private String secondName;

    @NotEmpty
    @Size(min = 1, max = 200,
            message = "${firstLastName} length must be between 1 and 200 characters.")
    private String firstLastName;

    @Size(min = 1, max = 200,
            message = "${secondLastName} length must be between 1 and 200 characters.")
    private String secondLastName;

    @NotEmpty
    private DocumentType documentType;

    @NotEmpty
    @Size(min = 1, max = 50,
            message = "${documentNumber} length must be between 1 and 50 characters.")
    private String documentNumber;

    @NotEmpty
    private GeolocationDTO geolocationDTO;

}
