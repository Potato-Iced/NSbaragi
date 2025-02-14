package com.tukorea.ns_baragi_server.likes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
