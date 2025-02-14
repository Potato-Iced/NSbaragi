package com.tukorea.ns_baragi_server.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/weather/count/{code}")
    public List<WeatherDTO> getCount(@PathVariable("code") Long code) {
        return weatherService.findbycode(code);
    }

    @PostMapping("/weather/add")
    public void addWeather(@RequestBody WeatherRequestBody surveylistfromrequestbody) {
        for (WeatherSurveyDTO wsdto : surveylistfromrequestbody.getSurveylist()) {
            weatherService.saveWeatherSurveyResult(wsdto, surveylistfromrequestbody.getCode());
        }
    }

}
