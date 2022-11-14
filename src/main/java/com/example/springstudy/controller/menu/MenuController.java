package com.example.springstudy.controller.menu;

import com.example.springstudy.dto.MenuDto;
import com.example.springstudy.service.menu.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public List<MenuDto> findAllMenuList() {
        List<MenuDto> nuDto = null;
        return nuDto;
    }


}
