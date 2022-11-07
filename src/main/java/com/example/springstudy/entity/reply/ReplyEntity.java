package com.example.springstudy.entity.reply;

import com.example.springstudy.dto.ReplyDto;
import com.example.springstudy.entity.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity(name="REPLY")
@Table(name="REPLY")
@RequiredArgsConstructor
@Getter
@SuperBuilder
public class ReplyEntity extends BaseEntity {

    @Id
    @Column(name = "REPLY_NO", nullable = false)
    private int replyNo;

    @Column(name = "REF", nullable = false)
    private int ref;

    @Column(name = "SEQ")
    private int seq;

    @Column(name = "HIGH_SEQ", nullable = false)
    private int highSeq;

    @Column(name = "DIR_SEQ")
    private int dirSeq;

    @Column(name = "REPLY_WRITER", nullable = false)
    @Builder.Default
    private String replyWriter = "";

    @Column(name = "REPLY_COMMENT", nullable = false)
    @Builder.Default
    private String replyComment = "";

    public static ReplyEntity builderFromDto(ReplyDto dto){
        return  ReplyEntity.builder()
                .replyNo(dto.getReplyNo())
                .ref(dto.getRef())
                .seq(dto.getSeq())
                .dirSeq(dto.getDirSeq())
                .highSeq(dto.getHighSeq())
                .replyWriter(dto.getReplyWriter())
                .replyComment(dto.getReplyComment())
                .createBy(dto.getCreateBy())
                .createDate(new Timestamp(System.currentTimeMillis()))
                .modifiedBy(dto.getModifiedBy())
                .modifiedDate(new Timestamp(System.currentTimeMillis()))
                .build();
    }

}
