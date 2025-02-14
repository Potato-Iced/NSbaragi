package com.tukorea.ns_baragi_server.cloth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClothDTO {
    private Integer id;
    private Long code;
    private Integer serialNumber;
    private String name;
    private String category;
    private Integer coldCount;
    private Integer normalCount;
    private Integer hotCount;
    private Integer totalCount;
    // Entity to DTO 변환용 생성자
    public ClothDTO(Cloth cloth) {
        this.id = cloth.getId();
        this.code = cloth.getCode();
        this.serialNumber = cloth.getSerialNumber();
        this.name = cloth.getName();
        this.category = cloth.getCategory();
        this.coldCount = cloth.getColdCount();
        this.normalCount = cloth.getNormalCount();
        this.hotCount = cloth.getHotCount();
        this.totalCount = cloth.getColdCount() + cloth.getNormalCount() + cloth.getHotCount();
    }

    public void plusCold(){
        this.coldCount++;
    }
    public void plusNormal(){
        this.normalCount++;
    }
    public void plusHot(){
        this.hotCount++;
    }

    public static ClothDTO toDTO(Cloth cloth){
        return ClothDTO.builder()
                .id(cloth.getId())
                .code(cloth.getCode())
                .serialNumber(cloth.getSerialNumber())
                .name(cloth.getName())
                .category(cloth.getCategory())
                .coldCount(cloth.getColdCount())
                .normalCount(cloth.getNormalCount())
                .hotCount(cloth.getHotCount())
                .totalCount(cloth.getTotalCount())
                .build();
    }



}
