package com.example.springstudy.dto;

import com.example.springstudy.entity.memo.MemoEntity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class MemoDto implements Serializable {
    private static final long serialVersionUID = 3119855506498368340L;
    private long memoSeq;
    private String memoTitle;
    private String memoContent;
    private String memoWriter;
    private Date createDate;
    private String createBy;
    private Date modifiedDate;
    private String modifiedBy;

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
