package com.example.demo.DTO;

import com.example.demo.enums.TypeOfRequest;
import lombok.Data;

@Data
public class AirRequest {
    private TypeOfRequest typeOfRequest;
    private AircraftRequeset aircraftRequeset;
}
