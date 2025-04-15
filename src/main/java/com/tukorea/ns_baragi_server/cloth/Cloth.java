package com.tukorea.ns_baragi_server.cloth;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Cloth")
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private Long code;

    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "cold_count")
    private Integer coldCount;

    @Column(name = "normal_count")
    private Integer normalCount;

    @Column(name = "hot_count")
    private Integer hotCount;

    @Column(name = "total_count", insertable = false, updatable = false)
    private Integer totalCount;
}
