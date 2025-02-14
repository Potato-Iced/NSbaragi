package com.tukorea.ns_baragi_server.cloth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClothRequestBody {
    public Long code;
    private List<ClothSurveyDTO> surveylist;
}
