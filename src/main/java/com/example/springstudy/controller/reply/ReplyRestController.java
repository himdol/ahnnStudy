package com.example.springstudy.controller.reply;

import com.example.springstudy.dto.ReplyDto;
import com.example.springstudy.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyRestController {

    private final ReplyService replyService;

//    public ReplyRestController (ReplyService replyService) {
//        this.replyService = replyService;
//    }

    @GetMapping("/save")
    public ReplyDto save() {
        ReplyDto dto = ReplyDto.builder().seq(1).build();
        replyService.testSelectNumberOne(dto);
        return null;
    }



}
