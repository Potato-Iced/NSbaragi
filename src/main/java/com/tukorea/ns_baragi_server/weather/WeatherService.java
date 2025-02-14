package com.tukorea.ns_baragi_server.weather;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<WeatherDTO> findbycode(Long code) {
        List<Weather> wl = weatherRepository.findByCode(code);
        List<WeatherDTO> wdto = new ArrayList<>();
        for (Weather w : wl) {
            wdto.add(WeatherDTO.toDTO(w));
        }
        return wdto;
    }

    public void saveWeatherSurveyResult(WeatherSurveyDTO wsdto){
        Weather w = weatherRepository.findBySerialNumberAndCode(wsdto.getSerialNumber(), wsdto.getCode());
        WeatherDTO dto = WeatherDTO.toDTO(w);
        switch(wsdto.getValue()){
            case 0:
                dto.plusOne();
                break;
            case 1:
                dto.plusTwo();
                break;
            case 2:
                dto.plusThree();
                break;
            case 3:
                dto.plusFour();
                break;
            default:
                System.out.println("Unexpected Value");
                break;
        }
        save(dto);
    }

    public void save(WeatherDTO dto) {
        Weather w = new Weather();
        w.setId(dto.getId());
        w.setCode(dto.getCode());
        w.setName(dto.getName());
        w.setValue1Count(dto.getValue1Count());
        w.setValue2Count(dto.getValue2Count());
        w.setValue3Count(dto.getValue3Count());
        w.setValue4Count(dto.getValue4Count());
        weatherRepository.save(w);
    }
}
