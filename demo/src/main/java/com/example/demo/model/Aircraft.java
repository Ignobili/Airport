package com.example.demo.model;

import com.example.demo.enums.AircraftType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aircraft_id", nullable = false)
    private Long aircraftId;

    @Enumerated(EnumType.STRING)
    @Column(name = "aircraft_type")
    private AircraftType aircraftType;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "registration_country", nullable = false)
    private String registrationCountry;

    @Column(name = "serial_number",nullable = false,unique = true)
    private String serialNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_slot_airport_slot_id")
    private AirportSlot airportSlot;

    @OneToOne(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private Airport airport;

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftType=" + aircraftType +
                ", registrationDate=" + registrationDate +
                ", registrationCountry='" + registrationCountry + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return getAircraftType() == aircraft.getAircraftType() && Objects.equals(getRegistrationDate(), aircraft.getRegistrationDate()) && Objects.equals(getRegistrationCountry(), aircraft.getRegistrationCountry()) && Objects.equals(getSerialNumber(), aircraft.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAircraftType(), getRegistrationDate(), getRegistrationCountry(), getSerialNumber());
    }
}