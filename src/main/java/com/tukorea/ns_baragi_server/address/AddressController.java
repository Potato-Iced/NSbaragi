package com.tukorea.ns_baragi_server.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("address/find")
    private Long findByJuso(@RequestParam(name = "sido") String sido,
                            @RequestParam(name = "sigungu") String sigungu) {
        return addressService.findbysidoandsigungu(sido, sigungu);
    }

    @GetMapping("address/find/{code}")
    private AddressDTO findByCode(@PathVariable("code") Long code) {
        return addressService.findbycode(code);
    }
}
