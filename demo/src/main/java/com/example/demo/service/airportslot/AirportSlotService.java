package com.example.demo.service.airportslot;

import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;
import com.example.demo.model.AirportSlot;

public interface AirportSlotService {

    AirportSlot bookHangar(Airport airport, Aircraft aircraft);

    void freeHangar(Airport airport, Aircraft aircraft);
}
