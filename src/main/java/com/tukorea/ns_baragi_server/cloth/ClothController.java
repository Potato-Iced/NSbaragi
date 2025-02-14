package com.tukorea.ns_baragi_server.cloth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClothController {
    private final ClothService clothService;

    @GetMapping("cloth/count/toptwo/{code}")
    public Map<String, List<ClothDTO>> countTopTwo(@PathVariable("code") Long code) {
        return clothService.getTop2ClothesByCategory(code);
    }
    @PostMapping("cloth/add")
    public void addClothSurvey (@RequestBody ClothRequestBody surveylistfromrequest) {
        for (ClothSurveyDTO csdto : surveylistfromrequest.getSurveylist()) {
            clothService.saveClothSurveyResult(csdto, surveylistfromrequest.getCode());
        }
    }
}
