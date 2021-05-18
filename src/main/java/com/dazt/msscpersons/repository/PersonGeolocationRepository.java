package com.dazt.msscpersons.repository;

import com.dazt.msscpersons.model.PersonGeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.UUID;

public interface PersonGeolocationRepository extends JpaRepository<PersonGeoLocation, UUID> {

    @Transactional
    @Modifying
    @Query("update PersonGeoLocation pg set pg.address = ?1, pg.district = ?2, pg.department = ?3, pg.country = ?4 where pg.personGeoLocationId = ?5 ")
    void updatePersonGeolocation(String address, String district, String department, String country, UUID personGeoLocationId);

}
