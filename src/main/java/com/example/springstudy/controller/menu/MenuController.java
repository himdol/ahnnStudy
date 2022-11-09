package com.example.springstudy.controller.menu;

import com.example.springstudy.service.menu.MenuService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }



}
