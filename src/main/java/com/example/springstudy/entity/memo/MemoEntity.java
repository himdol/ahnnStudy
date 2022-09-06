package com.example.springstudy.entity.memo;

import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.common.BaseEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "MEMO")
@Table(name = "MEMO")
//@Getter
//@Setter
@RequiredArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
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
//                .createBy(memoDto.getCreateBy())
//                .createDate(memoDto.getCreateDate())
//                .modifiedBy(memoDto.getModifiedBy())
//                .modifiedDate(memoDto.getModifiedDate())
                .build();
    }

}
