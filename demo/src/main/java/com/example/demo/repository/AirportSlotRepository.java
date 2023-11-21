package com.example.demo.repository;

import com.example.demo.model.AirportSlot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportSlotRepository extends CrudRepository<AirportSlot, Long> {
    List<AirportSlot> findByAirport_AirportIddAndAircraft_AircraftId(Long airportIdd, Long aircraftId);





}