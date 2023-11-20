package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "runway")
public class Runway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "runway_id", nullable = false)
    private Long runwayId;

    @Column(name = "freeAfter", nullable = false)
    private Date freeAfter;

    @ManyToOne
    @JoinColumn(name = "airport_airport_id")
    private Airport airport;




    public Boolean getFree(){
        return new java.util.Date().getTime() > this.freeAfter.getTime();
    }
    @Override
    public String toString() {
        return "Runway{" +
                "freeAfter=" + freeAfter +
                ", airport=" + airport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runway runway = (Runway) o;
        return Objects.equals(getFreeAfter(), runway.getFreeAfter()) && Objects.equals(getAirport(), runway.getAirport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFreeAfter(), getAirport());
    }
}