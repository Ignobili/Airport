package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "airport_slot")
public class AirportSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_slot_id", nullable = false)
    private Long airportSlotId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_airport_id")
    private Airport airport;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aircraft_aircraft_id")
    private Aircraft aircraft;

    @Override
    public String toString() {
        return "AirportSlot{" +
                "airport=" + airport +
                ", aircraft=" + aircraft +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportSlot that = (AirportSlot) o;
        return Objects.equals(getAirport(), that.getAirport()) && Objects.equals(getAircraft(), that.getAircraft());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAirport(), getAircraft());
    }
}