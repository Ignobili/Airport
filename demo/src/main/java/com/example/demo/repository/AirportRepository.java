package com.example.demo.repository;

import com.example.demo.model.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    @Query("select a from Airport a where a.airportIdd = ?1")
    Optional<Airport> findByAirportId(Long airportIdd);
}