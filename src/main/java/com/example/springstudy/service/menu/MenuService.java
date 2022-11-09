package com.example.springstudy.service.menu;

import com.example.springstudy.repository.menu.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

}
