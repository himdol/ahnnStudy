package com.example.springstudy.service.menu;

import com.example.springstudy.dto.MenuDto;
import com.example.springstudy.repository.menu.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuDto> findAllMenuList() {
        return menuRepository.findAllMenuList().stream().map(MenuDto :: entityToDto).collect(Collectors.toList());
    }

}
