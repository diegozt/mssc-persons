package com.dazt.msscpersons.mapper;

import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class UUIDMapper {

    public UUID convertStringToUUID(String source){
        if (source != null){
            return UUID.fromString(source);
        } else {
            return null;
        }
    }

    public String convertStringToUUID(UUID source){
        if (source != null){
            return source.toString();
        } else {
            return null;
        }
    }

}
