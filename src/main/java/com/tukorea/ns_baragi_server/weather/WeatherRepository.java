package com.tukorea.ns_baragi_server.weather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> findByCode(Long code);
    Weather findBySerialNumberAndCode(Integer serialNumber, Long code);

}
