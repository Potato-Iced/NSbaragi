package com.tukorea.ns_baragi_server.weather;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private Long code;
    @Column(name = "serial_number")
    private Integer serialNumber;
    @Column(name = "name")
    private String name;    // cloud(구름 상태), rain(비), humid(습도), sunlight(햇살), wind(바람)


    @Column(name = "value1_count")
    private Integer value1Count;
    @Column(name = "value2_count")
    private Integer value2Count;
    @Column(name = "value3_count")
    private Integer value3Count;
    @Column(name = "value4_count")
    private Integer value4Count;
    @Column(name = "total_count", insertable = false, updatable = false)
    private Integer totalCount;
}
