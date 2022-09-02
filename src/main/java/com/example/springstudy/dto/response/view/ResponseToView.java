package com.example.springstudy.dto.response.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseToView {

    private String type;

    @Data
    class item {
        private String message;
    }

}
