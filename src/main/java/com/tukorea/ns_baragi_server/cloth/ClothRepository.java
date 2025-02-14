package com.tukorea.ns_baragi_server.cloth;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ClothRepository extends JpaRepository<Cloth, Long> {
    Cloth findBySerialNumberAndCode(Integer serial_number, Long code);

    @Query("SELECT c FROM Cloth c WHERE c.code = :code AND c.category = :category  ORDER BY c.totalCount DESC")
    List<Cloth> findTop2ByCodeAndCategory(@Param("code") Long code, @Param("category") String category, Pageable pageable);
}
