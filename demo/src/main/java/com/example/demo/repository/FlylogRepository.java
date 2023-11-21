package com.example.demo.repository;

import com.example.demo.model.Flylog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlylogRepository extends CrudRepository<Flylog, Long> {
}