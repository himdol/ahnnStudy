package com.example.springstudy.controller.reply;

import com.example.springstudy.dto.ReplyDto;
import com.example.springstudy.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyRestController {

    private final ReplyService replyService;

    @PostMapping("/save")
    public int saveReply(@RequestBody ReplyDto replyDto) {
        return replyService.saveReply(replyDto);
    }

//    @GetMapping("/get")
//    public List<ReplyDto>



}
