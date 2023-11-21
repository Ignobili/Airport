package com.example.demo.util;

import com.example.demo.enums.AircraftType;
import com.example.demo.enums.AirportType;
import com.example.demo.exception.AircraftNotAllowedException;
import com.example.demo.exception.NoFreeRunwayException;
import com.example.demo.exception.NofreeHangarException;
import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;

public class AirportUtil {

    public static void isCompatible(Aircraft aircraft, Airport airport){
        if((aircraft.getAircraftType() == AircraftType.CARGO && airport.getAirportType() == AirportType.INTERNATIONAL) || (aircraft.getAircraftType() == AircraftType.NORMAL && airport.getAirportType() == AirportType.REGIONAL)){

            throw new AircraftNotAllowedException();

        }
    }

    public static void isFreeRunway(Airport airport){

        if(airport.getRunways().stream().allMatch(runway -> Boolean.FALSE.equals(runway.getFree()))){
            throw new NoFreeRunwayException();
        }
    }

    public static void isFreeHangar(Airport airport){

        if(airport.getAirportSlots().stream().allMatch(airportSlot -> airportSlot.getAircraft()!= null)){

            throw new NofreeHangarException();
        }

    }
}
