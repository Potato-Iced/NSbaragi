package com.tukorea.ns_baragi_server.likes;

import org.springframework.stereotype.Service;

@Service
public class LikesService {
    private final LikesRepository likesRepository;
    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    public LikesDTO findbycode(Long code) {
        LikesDTO dto = LikesDTO.toDTO(likesRepository.findByCode(code));
        return dto;
    }

    public int toPercent(LikesDTO dto){
        int l = dto.getLikes();
        int dl = dto.getDislikes();
        int sum = l + dl;
        float percentage = (float)l/(float)sum * 100.0f;
        return Math.round(percentage);
    }

    public void save(LikesDTO dto) {
        Likes li = new Likes();
        li.setCode(dto.getCode());
        li.setLikes(dto.getLikes());
        li.setDislikes(dto.getDislikes());
        likesRepository.save(li);
    }
}
