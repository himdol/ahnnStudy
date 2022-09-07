package com.example.springstudy.controller.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memo")
public class MemoController {

    @GetMapping("/index")
    public String showIndexPage(){
        return "memo/index";
    }

    @GetMapping("/detail")
    public String showDetailPage () {
        return "memo/detail";
    }
}
