package com.example.springstudy.controller.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/memo")
public class MemoController {

    @GetMapping("/index")
    public String showIndexPage(){
        return "memo/index";
    }

    @GetMapping("/detail")
    public String showDetailPage(@RequestParam @Valid Long memoSeq) {
        System.out.println(memoSeq);
        return "memo/detail";
    }
}
