package com.example.springstudy.entity.memo;

import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.common.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity(name = "MEMO")
@Table(name = "MEMO")
@Getter
@RequiredArgsConstructor
@SuperBuilder
public class MemoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMO_SEQ", nullable = false)
    private long memoSeq;

    @Column(name = "MEMO_TITLE", nullable = false)
    private String memoTitle;

    @Column(name = "MEMO_CONTENT", nullable = false)
    private String memoContent;

    @Column(name = "MEMO_WRITER", nullable = false)
    private String memoWriter;

    public static MemoEntity builderFromDto(MemoDto memoDto){
        return MemoEntity.builder()
                .memoSeq(memoDto.getMemoSeq())
                .memoTitle(memoDto.getMemoTitle())
                .memoContent(memoDto.getMemoContent())
                .memoWriter(memoDto.getMemoWriter())
                .createBy(memoDto.getCreateBy())
                .createDate(memoDto.getCreateDate())
                .modifiedBy(memoDto.getModifiedBy())
                .modifiedDate(memoDto.getModifiedDate())
                .build();
    }

}