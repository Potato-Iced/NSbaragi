package com.tukorea.ns_baragi_server.cloth;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClothSurveyDTO {
    public Long code;
    public Integer serial_number;
    public Integer value;
}
