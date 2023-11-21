package com.example.demo.repository;

import com.example.demo.model.Runway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunwayRepository extends CrudRepository<Runway, Long> {
}