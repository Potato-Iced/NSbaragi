package com.tukorea.ns_baragi_server.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WeatherRequestBody {
    public Long code;
    public List<WeatherSurveyDTO> surveylist;
}
