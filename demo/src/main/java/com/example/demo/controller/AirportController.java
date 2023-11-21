package com.example.demo.controller;

import com.example.demo.DTO.AirRequest;
import com.example.demo.service.airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AirportController {


    @Autowired
    private AirportService airportService;

    @PostMapping("/{airportId}")
    @ResponseBody
    public void newFlight(@RequestBody AirRequest airRequest, @PathVariable Long airportId){

        airportService.createFlight(airportId,airRequest);

    }

    @PostMapping("/create")
    @ResponseBody
    public String createAirport(){
        airportService.createAirport();
        return "Successful";
    }
}
