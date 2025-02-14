package com.tukorea.ns_baragi_server.address;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressDTO {
    private Long code;
    private String sido;
    private String sigungu;

    public static AddressDTO toDTO(Address address) {
        return AddressDTO.builder()
                .code(address.getCode())
                .sido(address.getSido())
                .sigungu(address.getSigungu())
                .build();
    }
}
