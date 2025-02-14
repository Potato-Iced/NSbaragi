package com.tukorea.ns_baragi_server.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    Address findBySidoAndSigungu(String sido, String sigungu);
    Address findByCode(Long code);
}