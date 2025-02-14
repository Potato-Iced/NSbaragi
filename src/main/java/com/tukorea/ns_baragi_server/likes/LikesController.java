package com.tukorea.ns_baragi_server.likes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    @GetMapping("/likes/result/{code}")
    public LikesDTO getLikesRatio(@PathVariable("code") Long code) {
        return likesService.findbycode(code);
    }

    @GetMapping("/likes/add")
    public String addLikes(@RequestParam(name="code") Long code, @RequestParam(name="likes") byte likes) {
        LikesDTO dto = likesService.findbycode(code);
        if (likes == 1){
            dto.plusLikes();
        }
        else if (likes == 0) {
            dto.plusDislikes();
        }
        else {
            // 이상한 값 받았을 때 뭔가 에러를 띄우고 싶은데..
            System.out.println("올바른 값이 아닙니다ㅏㅏ");
        }
        likesService.save(dto);
        // for debug, 원래는 리턴값 없습니당
        dto = likesService.findbycode(code);
        String result = "좋아요: " + dto.getLikes().toString() + " / 싫어요: " + dto.getDislikes().toString();
        return result;
    }
}
