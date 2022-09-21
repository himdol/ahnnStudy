package com.example.springstudy.service.reply;

import com.example.springstudy.dto.ReplyDto;
import com.example.springstudy.entity.reply.ReplyEntity;
import com.example.springstudy.repository.reply.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    private ReplyRepository replyRepository;

    public ReplyService (ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public ReplyDto testSelectNumberOne(ReplyDto dto) {

        ReplyEntity replyEntity = ReplyEntity.builderFromDto(dto);

        List<ReplyEntity> replyEntitys = replyRepository.testSelectNumberOne(replyEntity);
        return null;
    }
}
