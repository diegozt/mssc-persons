package com.dazt.msscpersons.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseDTO {

    @NotEmpty(message = "${id} must not be empty.")
    private String id;

    @NotEmpty(message = "${lastUserUpdate} must not be empty.")
    private String lastUserUpdate;

    @NotEmpty(message = "${lastDateUpdate} must not be empty.")
    @PastOrPresent(message = "${lastDateUpdate} must to be past or present, not future.")
    private OffsetDateTime lastDateUpdate;

    @NotEmpty(message = "${userCreated} must not be empty.")
    private String userCreated;

    @NotEmpty(message = "${createdDate} must not be empty.")
    @PastOrPresent(message = "${createdDate} must to be past or present, not future.")
    private OffsetDateTime createdDate;

    @NotEmpty(message = "${environmentPort} must not be empty.")
    @Positive(message = "${environmentPort} must to be a valid value - numeric and positive.")
    private String environmentPort;

}
