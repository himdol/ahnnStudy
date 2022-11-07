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

    public int saveReply(ReplyDto dto) {
        return replyRepository.saveReply(ReplyEntity.builderFromDto(dto));
    }

    public List<ReplyDto> findAllByHighSeqOrderByRefAscDirSeqAsc(ReplyDto replyDto) {
        return ReplyDto.builderFromEntityList(replyRepository.findAllByHighSeqOrderByRefAscDirSeqAsc(Integer.valueOf(ReplyEntity.builderFromDto(replyDto).getHighSeq())));
    }

    public int updateByReplyNo(ReplyDto dto) {
        return replyRepository.updateByReplyNo(ReplyEntity.builderFromDto(dto));
    }

    public int deleteByReplyNo(ReplyDto dto) {
        return replyRepository.deleteByReplyNo(Integer.valueOf(ReplyEntity.builderFromDto(dto).getReplyNo()));
    }

}
