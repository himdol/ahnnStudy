package com.example.springstudy.controller.reply;

import com.example.springstudy.dto.ReplyDto;
import com.example.springstudy.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyRestController {

    private final ReplyService replyService;

    @PostMapping("/save")
    public int saveReply(@RequestBody ReplyDto replyDto) {
        return replyService.saveReply(replyDto);
    }

    @PostMapping("/detail")
    public List<ReplyDto> findAllByHighSeqOrderByRefAscDirSeqAsc(@RequestBody ReplyDto replyDto) {
        return replyService.findAllByHighSeqOrderByRefAscDirSeqAsc(replyDto);
    }



}
