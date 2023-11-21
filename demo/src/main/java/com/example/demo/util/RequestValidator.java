package com.example.demo.util;

import com.example.demo.DTO.AirRequest;
import com.example.demo.exception.BadException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestValidator implements Validator{

    private AirRequest request;
    @Override
    public void validate() {
        if  (!(this.request != null &&
                this.request.getTypeOfRequest() != null &&
                this.request.getAircraftRequeset()!= null &&
                this.request.getAircraftRequeset().getRegistrationDate() != null &&
                this.request.getAircraftRequeset().getAircraftType() != null &&
                this.request.getAircraftRequeset().getSerialNumber() != null &&
                this.request.getAircraftRequeset().getRegistrationCountry() != null)) {

                System.out.println("New request did not contain all attributes that were needed!");
            throw new BadException();
        }
    }
}