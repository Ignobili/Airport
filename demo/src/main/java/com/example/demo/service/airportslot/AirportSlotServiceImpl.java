package com.example.demo.service.airportslot;

import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;
import com.example.demo.model.AirportSlot;
import com.example.demo.repository.AirportSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportSlotServiceImpl implements AirportSlotService{

    @Autowired
    private AirportSlotRepository airportSlotRepository;
    @Override
    public AirportSlot bookHangar(Airport airport, Aircraft aircraft) {

        AirportSlot airportSlot = (AirportSlot) airportSlotRepository.findByAirport_AirportIddAndAircraft_AircraftId(airport.getAirportIdd(),aircraft.getAircraftId());
        airportSlot.setAircraft(aircraft);

        return airportSlotRepository.save(airportSlot);
    }

    @Override
    public void freeHangar(Airport airport, Aircraft aircraft) {

        AirportSlot airportSlot = (AirportSlot) airportSlotRepository.findByAirport_AirportIddAndAircraft_AircraftId(airport.getAirportIdd(), aircraft.getAircraftId());
        airportSlot.setAircraft(null);
        airportSlotRepository.save(airportSlot);
    }
}
