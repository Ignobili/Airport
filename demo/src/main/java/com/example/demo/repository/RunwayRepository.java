package com.example.demo.repository;

import com.example.demo.model.Runway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunwayRepository extends CrudRepository<Runway, Long> {
    List<Runway> findByAirport_AirportIdd(Long airportIdd);


}