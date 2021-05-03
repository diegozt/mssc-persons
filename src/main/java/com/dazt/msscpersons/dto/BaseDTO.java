package com.dazt.msscpersons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
