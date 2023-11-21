package com.example.demo.repository;

import com.example.demo.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
    Optional<Airport> findByAirportId(Long airportId);

}