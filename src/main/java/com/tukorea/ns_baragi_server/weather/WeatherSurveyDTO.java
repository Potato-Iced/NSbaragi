package com.tukorea.ns_baragi_server.weather;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WeatherSurveyDTO {
    public Long code;
    public Integer serialNumber;
    public Integer value;
}
