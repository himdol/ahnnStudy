package com.example.springstudy.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.Column;
import java.util.Date;

@Builder
@Data
public class ReplyDto {

    @Column(name = "SEQ")
    private int SEQ;

    @Column(name = "HIGH_SEQ", nullable = false)
    private int highSeq;

    @Column(name = "DIR_SEQ")
    private int dirSeq;

    @Column(name = "REPLY_WRITER", nullable = false)
    private String replyWriter;

    @Column(name = "REPLY_COMMENT", nullable = false)
    private String replyComment;

    @Column(name = "DEL_YN", nullable = false)
    @Builder.Default
    private String delYn = "N";

    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createDate;

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    @Builder.Default
    @CreatedBy
    private String createBy = "";

    @Column(name = "MODIFIED_DATE", nullable = false)
    @LastModifiedDate
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY", nullable = false)
    @Builder.Default
    @LastModifiedBy
    private String modifiedBy = "";
}
