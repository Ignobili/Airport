package com.example.demo.repository;

import com.example.demo.model.AirportSlot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportSlotRepository extends CrudRepository<AirportSlot, Long> {
}