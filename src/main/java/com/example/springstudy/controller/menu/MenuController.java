package com.example.springstudy.controller.menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/index")
    public String showWitchPage() {
        return null;
    }


}
