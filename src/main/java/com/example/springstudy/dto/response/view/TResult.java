package com.example.springstudy.dto.response.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TResult {

    /***
     * header
     * body
     *
     * 상태값
     * 리턴값
     * 메시지
     */

    private String type;

    @Data
    class item {
        private String message;
    }

}
