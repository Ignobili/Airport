package com.example.demo.service.runway;

import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;
import com.example.demo.model.Runway;
import com.example.demo.repository.RunwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RunwayServiceImpl implements RunwayService{

    @Autowired
    private RunwayRepository runwayRepository;

    @Override
    public void bookRunway(Airport airport, Aircraft aircraft) {

        List<Runway> runways = runwayRepository.findByAirport_AirportIdd(airport.getAirportIdd());
        Runway runway  = runways.stream().filter(runway1 -> runway1.getFreeAfter().before(new Date())).findFirst().get();
        long timeToSet = new Date().getTime()+300;
        runway.setFreeAfter(new java.sql.Date(timeToSet));
        runwayRepository.save(runway);


    }
}
