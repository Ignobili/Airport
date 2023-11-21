package com.example.demo.service.airport;

import com.example.demo.DTO.AirRequest;
import com.example.demo.enums.AirportType;
import com.example.demo.enums.FlylogType;
import com.example.demo.enums.TypeOfRequest;
import com.example.demo.exception.BadException;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.AirportRepository;
import com.example.demo.service.aircraft.AircraftService;
import com.example.demo.service.airportslot.AirportSlotService;
import com.example.demo.service.flylog.FlylogService;
import com.example.demo.service.runway.RunwayService;
import com.example.demo.util.AirportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private FlylogService flylogService;

    @Autowired
    private AirportSlotService airportSlotService;

    @Autowired
    private RunwayService runwayService;

    @Override
    public void createFlight(Long airportId, AirRequest airRequest) {

        Airport airport = airportRepository.findByAirportId(airportId).orElseThrow(IdNotFoundException:: new);
        Aircraft aircraft  = aircraftService.findAircraft(airRequest.getAircraftRequeset().getSerialNumber());
        if(aircraft == null){
            aircraft = aircraftService.create(airRequest.getAircraftRequeset());
            System.out.println("First time visiting");
        }

        AirportUtil.isCompatible(aircraft,airport);
        AirportUtil.isFreeRunway(airport);
        if(airRequest.getTypeOfRequest() == TypeOfRequest.LANDING){
            if (aircraft.getAirportSlot()!= null) {
                throw new BadException();
            }
            AirportUtil.isFreeHangar(airport);
        }



    }

    @Override
    public void createAirport() {

        Airport airport = new Airport();
        airport.setHangarCapacity(2);
        airport.setRunwayCapacity(10);
        airport.setAirportType(AirportType.REGIONAL);
        airportRepository.save(airport);
        System.out.println("New Airport successfully created!");


    }

    private void landAircraft(Aircraft aircraft, Airport airport){

        flylogService.createNewFlylog(new Flylog(FlylogType.ARRIVAL, airport.getAirportIdd(), aircraft.getAircraftId()));
        runwayService.bookRunway(airport,aircraft);
        airportSlotService.freeHangar(airport,aircraft);
        airport.setAirportSlots(null);
        aircraftService.update(aircraft);

    }

    private void flyAircraft(Airport airport,Aircraft aircraft){
        flylogService.createNewFlylog(new Flylog(FlylogType.DEPARTURE,airport.getAirportIdd(),aircraft.getAircraftId()));
        runwayService.bookRunway(airport,aircraft);
        airportSlotService.freeHangar(airport,aircraft);
        aircraft.setAirportSlot(null);
        aircraftService.update(aircraft);
    }

    private void setSlot(Airport airport){
        for(int i = 0; i<airport.getHangarCapacity();i++){
            AirportSlot airportSlot = new AirportSlot();
            airportSlot.setAirport(airport);
            airport.getAirportSlots().add(airportSlot);
        }
    }

    private void setRunway(Airport airport){

        for(int i = 0; i<airport.getHangarCapacity();i++){
            Runway runway = new Runway();
            runway.setAirport(airport);
            runway.setFreeAfter((java.sql.Date) new Date());
            airport.getRunways().add(runway);
        }

    }

}
