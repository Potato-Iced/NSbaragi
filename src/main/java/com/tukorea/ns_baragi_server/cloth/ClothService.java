package com.tukorea.ns_baragi_server.cloth;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClothService {
    private final ClothRepository clothRepository;
    private final String[] categoryList = {"outer", "top", "bottom"};
    public ClothService(ClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    public void save(ClothDTO clothDTO){
        Cloth c = new Cloth();
        c.setId(clothDTO.getId());
        c.setSerialNumber(clothDTO.getSerialNumber());
        c.setName(clothDTO.getName());
        c.setCode(clothDTO.getCode());
        c.setCategory(clothDTO.getCategory());
        c.setColdCount(clothDTO.getColdCount());
        c.setNormalCount(clothDTO.getNormalCount());
        c.setHotCount(clothDTO.getHotCount());
        clothRepository.save(c);
    }
    public void saveClothSurveyResult(ClothSurveyDTO csdto, Long code){
        Cloth c = clothRepository.findBySerialNumberAndCode(csdto.getSerial_number(), code);
        ClothDTO dto = ClothDTO.toDTO(c);
        switch(csdto.getValue()){
            case 0: //추움
                dto.plusCold();
                break;
            case 1: //좋음
                dto.plusNormal();
                break;
            case 2: // 더움
                dto.plusHot();
                break;
            default:
                System.out.println("Unexpected Value");
                break;
        }
        save(dto);
    }

    public Map<String, List<ClothDTO>> getTop2ClothesByCategory(Long code) {
        Map<String, List<ClothDTO>> result = new HashMap<>();
        PageRequest topTwo = PageRequest.of(0, 2);

        for (String category : categoryList) {
            List<ClothDTO> top2DTOs = clothRepository.findTop2ByCodeAndCategory(code, category, topTwo)
                    .stream()
                    .map(ClothDTO::new)  // 엔티티 -> DTO 변환
                    .collect(Collectors.toList());
            result.put(category, top2DTOs);
        }

        return result;
    }
}
