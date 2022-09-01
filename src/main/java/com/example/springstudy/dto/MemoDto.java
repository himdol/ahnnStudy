package com.example.springstudy.dto;

import com.example.springstudy.utills.adapter.AdapterUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class MemoDto implements Serializable, AdapterUtil {
    private static final long serialVersionUID = 3119855506498368340L;
    private Integer memoSeq;
    private String memoTitle;
    private String memoContent;
    private String memoWriter;

    @Override
    public Object converterDtoToEntity(Object object) {


        return null;
    }

    @Override
    public Object converterEntityToDto(Object object) {
        return null;
    }
}
