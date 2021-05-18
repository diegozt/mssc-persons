package com.dazt.msscpersons.repository;

import com.dazt.msscpersons.model.Person;
import com.dazt.msscpersons.model.PersonGeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonGeolocationRepository extends JpaRepository<PersonGeoLocation, UUID> {

}
