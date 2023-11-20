package com.example.demo.model;

import com.example.demo.enums.AirportType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id", nullable = false)
    private Long airportIdd;

    @Column(nullable = false, name = "hangar_capacity")
    private Integer hangarCapacity;

    @Column(nullable = false, name = "runway_capacity")
    private Integer runwayCapacity;

    @Column(nullable = false, name = "airport_type")
    private AirportType airportType;

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<AirportSlot> airportSlots = new ArrayList<>();

    @OneToMany(mappedBy = "airport", orphanRemoval = true)
    private List<Runway> runways = new ArrayList<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "aircraft_aircraft_id")
    private Aircraft aircraft;

    @Override
    public String toString() {
        return "Airport{" +
                "hangarCapacity=" + hangarCapacity +
                ", runwayCapacity=" + runwayCapacity +
                ", airportType=" + airportType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(getHangarCapacity(), airport.getHangarCapacity()) && Objects.equals(getRunwayCapacity(), airport.getRunwayCapacity()) && getAirportType() == airport.getAirportType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHangarCapacity(), getRunwayCapacity(), getAirportType());
    }
}