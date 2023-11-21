package com.example.demo.service.airport;


import com.example.demo.DTO.AirRequest;

public interface AirportService {

    void createFlight(Long airportId, AirRequest airRequest);
    void createAirport();
}
