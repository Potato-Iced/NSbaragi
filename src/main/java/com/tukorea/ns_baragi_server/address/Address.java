package com.tukorea.ns_baragi_server.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Address {
    @Id
    @Column(name = "code")
    private Long code;

    @Column(name = "sido")
    private String sido; //서울, 인천 등 시

    @Column(name = "sigungu")
    private String sigungu; //시흥시 등 시군구
}
