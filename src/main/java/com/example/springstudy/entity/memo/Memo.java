package com.example.springstudy.entity.memo;

import com.example.springstudy.entity.common.BaseEntity;
import com.example.springstudy.utills.ObjectUtils.ObjectCustomUtils;
import com.example.springstudy.utills.adapter.AdapterUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Memo extends BaseEntity implements AdapterUtil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMO_SEQ", nullable = false)
    private Integer memoSeq;

    @Column(name = "MEMO_TITLE", nullable = false)
    private String memoTitle;

    @Column(name = "MEMO_CONTENT", nullable = false)
    private String memoContent;

    @Column(name = "MEMO_WRITER", nullable = false)
    private String memoWriter;

    @Override
    public Object converterDtoToEntity(Object object) {

        if (ObjectCustomUtils.isNotEmpty(object)){
        } else {
            return null;
        }

        return null;
    }

    @Override
    public Object converterEntityToDto(Object object) {
        return null;
    }
}
