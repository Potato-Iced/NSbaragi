package com.tukorea.ns_baragi_server.address;

import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Long findbysidoandsigungu(String sido, String sigungu){
        AddressDTO dto = AddressDTO.toDTO(addressRepository.findBySidoAndSigungu(sido, sigungu));
        return dto.getCode();

    }

    public AddressDTO findbycode(Long code){
        return AddressDTO.toDTO(addressRepository.findByCode(code));
    }
}
