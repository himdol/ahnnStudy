package com.example.springstudy.dto;

import com.example.springstudy.entity.reply.ReplyEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
public class ReplyDto implements Serializable {

    private static final long serialVersionUID = 4253638076541695230L;

    @Column(name = "seq")
    private int seq;
    private int highSeq;
    private int dirSeq;
    private String replyWriter;
    private String replyComment;
    private String delYn;
    private Date createDate;
    private String createBy;
    private Date modifiedDate;
    private String modifiedBy;
    public static ReplyDto builderFromEntity(ReplyEntity entity){
        return  ReplyDto.builder()
                .seq(entity.getSeq())
                .dirSeq(entity.getDirSeq())
                .highSeq(entity.getHighSeq())
                .replyWriter(entity.getReplyWriter())
                .replyComment(entity.getReplyComment())
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }
}
