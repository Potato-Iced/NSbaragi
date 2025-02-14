package com.tukorea.ns_baragi_server.weather;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {
    private Integer id;
    private Long code;
    private Integer serialNumber;
    private String name;
    private Integer value1Count;
    private Integer value2Count;
    private Integer value3Count;
    private Integer value4Count;
    private Integer totalCount;

    public void plusOne() {
        this.value1Count++;
    }
    public void plusTwo() {
        this.value2Count++;
    }
    public void plusThree() {
        this.value3Count++;
    }
    public void plusFour() {
        this.value4Count++;
    }
    public static WeatherDTO toDTO(Weather weather) {
        return WeatherDTO.builder()
                .id(weather.getId())
                .code(weather.getCode())
                .serialNumber(weather.getSerialNumber())
                .name(weather.getName())
                .value1Count(weather.getValue1Count())
                .value2Count(weather.getValue2Count())
                .value3Count(weather.getValue3Count())
                .value4Count(weather.getValue4Count())
                .totalCount(weather.getTotalCount())
                .build();
    }

}