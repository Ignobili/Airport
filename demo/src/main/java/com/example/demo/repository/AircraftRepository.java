package com.example.demo.repository;

import com.example.demo.model.Aircraft;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    Aircraft getBySerialNumber(String serialNumber);
    List<Aircraft> getByRegistrationCountry(String countryCode);



}