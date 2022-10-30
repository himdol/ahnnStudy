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

@Entity(name="REPLY")
@Table(name="REPLY")
@RequiredArgsConstructor
@Getter
@SuperBuilder
public class ReplyEntity extends BaseEntity {

    @Column(name = "REF")
    private int ref;

    @Column(name = "SEQ")
    @Id
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
                .ref(dto.getRef())
                .seq(dto.getSeq())
                .dirSeq(dto.getDirSeq())
                .highSeq(dto.getHighSeq())
                .replyWriter(dto.getReplyWriter())
                .replyComment(dto.getReplyComment())
                .createBy(dto.getCreateBy())
                .createDate(dto.getCreateDate())
                .modifiedBy(dto.getModifiedBy())
                .modifiedDate(dto.getModifiedDate())
                .build();
    }

}
