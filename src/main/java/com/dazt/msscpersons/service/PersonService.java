package com.dazt.msscpersons.service;

import com.dazt.msscpersons.model.Person;

public interface PersonService {

    Person findByFirstName(String name);

}
