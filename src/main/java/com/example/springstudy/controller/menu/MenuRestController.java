package com.example.springstudy.controller.menu;

import com.example.springstudy.dto.MenuDto;
import com.example.springstudy.service.menu.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuRestController {
    private MenuService menuService;

    public MenuRestController( MenuService menuService ) {
        this.menuService = menuService;
    }

    //#region - 메뉴 생성

    @RequestMapping("/indexPageMenu")
    public List<MenuDto> findAllMenuList() {
        return menuService.findAllMenuList();
    }

    //#endregion
}
