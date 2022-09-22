package com.example.springstudy.controller.reply;

import com.example.springstudy.dto.ReplyDto;
import com.example.springstudy.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyRestController {

    private final ReplyService replyService;

    @PostMapping("/save")
    public ReplyDto saveReply(@RequestBody ReplyDto replyDto) {
        replyService.saveReply(replyDto);
        return null;
    }



}
