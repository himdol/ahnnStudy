package com.example.springstudy.entity.reply;

import com.example.springstudy.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="REPLY")
@Table(name="REPLY")
public class ReplyEntity extends BaseEntity {

    @Column(name = "SEQ")
    @Id
    private int SEQ;

    @Column(name = "HIGH_SEQ", nullable = false)
    private int highSeq;

    @Column(name = "DIR_SEQ")
    private int dirSeq;

    @Column(name = "REPLY_WRITER", nullable = false)
    private String replyWriter;

    @Column(name = "REPLY_COMMENT", nullable = false)
    private String replyComment;

}
