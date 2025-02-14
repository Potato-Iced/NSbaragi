package com.tukorea.ns_baragi_server.likes;

import org.springframework.stereotype.Service;

@Service
public class LikesService {
    private final LikesRepository likesRepository;
    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    public LikesDTO findbycode(Long code) {
        return LikesDTO.toDTO(likesRepository.findByCode(code));
    }
    public void save(LikesDTO dto) {
        Likes li = new Likes();
        li.setCode(dto.getCode());
        li.setLikes(dto.getLikes());
        li.setDislikes(dto.getDislikes());
        likesRepository.save(li);
    }
}
