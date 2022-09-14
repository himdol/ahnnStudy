package com.example.springstudy.controller.reply;

import com.example.springstudy.dto.ReplyDto;
import com.example.springstudy.service.reply.ReplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
public class ReplyRestController {

    private ReplyService replyService;

    public ReplyRestController (ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping("/save")
    public ReplyDto save(@RequestBody ReplyDto replyDto) {
        replyService.testSelectNumberOne(1);
        return null;
    }



}
