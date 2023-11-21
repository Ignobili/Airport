package com.example.demo.service.runway;

import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;

public interface RunwayService {
    void bookRunway(Airport airport, Aircraft aircraft);
}
