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
        ReplyEntity replyEntity = ReplyEntity.builderFromDto(dto);
        int result = replyRepository.saveReply(replyEntity);
        return result;
    }

    public List<ReplyDto> findAllByHighSeqOrderByRefAscDirSeqAsc(ReplyDto replyDto) {
        Integer highSeq = Integer.valueOf(ReplyEntity.builderFromDto(replyDto).getHighSeq());
        return ReplyDto.builderFromEntityList(replyRepository.findAllByHighSeqOrderByRefAscDirSeqAsc(highSeq));
    }

    public int updateReply(ReplyDto dto) {
        ReplyEntity replyEntity = ReplyEntity.builderFromDto(dto);
        return replyRepository.updateReply(replyEntity);
    }

    public int deleteBySeq(ReplyDto dto) {
        ReplyEntity replyEntity = ReplyEntity.builderFromDto(dto);
        return replyRepository.deleteBySeq(replyEntity.getSeq());
    }

}
