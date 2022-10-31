package com.example.springstudy.dto;

import com.example.springstudy.entity.memo.MemoEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
public class MemoDto implements Serializable {
    private static final long serialVersionUID = 3119855506498368340L;

    @Column(name = "memoSeq")
    private long memoSeq;

    @NotNull
    private String memoTitle;

    @NotNull
    private String memoContent;

    @NotNull
    private String memoWriter;
    private Timestamp createDate;
    private String createBy = "";
    private Timestamp modifiedDate;
    private String modifiedBy = "";

    public static MemoDto builderFromEntity(MemoEntity memoEntity){
        return MemoDto.builder()
                .memoSeq(memoEntity.getMemoSeq())
                .memoTitle(memoEntity.getMemoTitle())
                .memoContent(memoEntity.getMemoContent())
                .memoWriter(memoEntity.getMemoWriter())
                .createBy(memoEntity.getCreateBy())
                .createDate(memoEntity.getCreateDate())
                .modifiedBy(memoEntity.getModifiedBy())
                .modifiedDate(memoEntity.getModifiedDate())
                .build();
    }
}
