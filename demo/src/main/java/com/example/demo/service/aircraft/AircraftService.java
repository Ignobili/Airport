package com.example.demo.service.aircraft;

import com.example.demo.DTO.AircraftRequeset;
import com.example.demo.model.Aircraft;

import java.util.List;

public interface AircraftService {


    Aircraft findAircraft(String serialNumber);

    Aircraft create(AircraftRequeset aircraftRequeset);

    Aircraft update(Aircraft aircraft);

    List<Aircraft> getByCountry(String country);

}
