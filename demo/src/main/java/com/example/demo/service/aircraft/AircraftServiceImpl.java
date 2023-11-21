package com.example.demo.service.aircraft;

import com.example.demo.DTO.AircraftRequeset;
import com.example.demo.enums.AircraftType;
import com.example.demo.model.Aircraft;
import com.example.demo.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    AircraftRepository aircraftRepository;
    @Override
    public Aircraft findAircraft(String serialNumber) {

        return aircraftRepository.getBySerialNumber(serialNumber);
    }

    @Override
    public Aircraft create(AircraftRequeset aircraftRequeset) {
            Aircraft aircraft = new Aircraft();
            aircraft.setSerialNumber(aircraftRequeset.getSerialNumber());
            aircraft.setAircraftType(aircraftRequeset.getAircraftType() == AircraftType.CARGO ? AircraftType.CARGO : AircraftType.NORMAL);
            aircraft.setRegistrationCountry(aircraftRequeset.getRegistrationCountry());
            aircraft.setRegistrationDate((Date) aircraftRequeset.getRegistrationDate());

        return aircraftRepository.save(aircraft);
    }

    @Override
    public Aircraft update(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public List<Aircraft> getByCountry(String country) {
        return aircraftRepository.getByRegistrationCountry(country);
    }
}
