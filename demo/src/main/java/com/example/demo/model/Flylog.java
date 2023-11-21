package com.example.demo.model;

import com.example.demo.enums.FlylogType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flylog")
public class Flylog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flylog_id", nullable = false)
    private Long flylogId;

    @Enumerated(EnumType.STRING)
    @Column(name = "flylog_type")
    private FlylogType flylogType;

    @Column(name = "airport_id")
    private Long aiport_id;
    @Column(name = " airport_slot_id ")
    private Long airport_slot_id;

    public Flylog(FlylogType flylogType, Long airportIdd, Long aircraftId) {

    }

    @Override
    public String toString() {
        return "Flylog{" +
                "flylogType=" + flylogType +
                ", aiport_id=" + aiport_id +
                ", airport_slot_id=" + airport_slot_id +
                '}';
    }
}