package com.example.demo.DTO;

import com.example.demo.enums.AircraftType;
import lombok.Data;

import java.util.Date;

@Data

public class AircraftRequeset {
    private AircraftType aircraftType;
    private Date registrationDate;
    private String registrationCountry;
    private String serialNumber;
}
