package com.tukorea.ns_baragi_server.likes;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LikesDTO {
    private Long code;
    private Integer likes;
    private Integer dislikes;

    public void plusLikes(){
        this.likes++;
    }
    public void plusDislikes(){
        this.dislikes++;
    }
    public static LikesDTO toDTO(Likes likes){
        return LikesDTO.builder()
                .code(likes.getCode())
                .likes(likes.getLikes())
                .dislikes(likes.getDislikes())
                .build();
    }
}
