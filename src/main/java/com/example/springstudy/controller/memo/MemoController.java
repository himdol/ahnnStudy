package com.example.springstudy.controller.memo;

import com.example.springstudy.service.menu.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/memo")
public class MemoController {

    private MenuService menuService;
    public MemoController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/index")
    public String showIndexPage(){
        return "memo/index";
    }

    @GetMapping("/detail")
    public String showDetailPage(@RequestParam @Valid Long memoSeq, Model model) {
        model.addAttribute("memoSeq", memoSeq);
        return "memo/detail";
    }

    @GetMapping("/gnb")
    public String showGnbList(Model model) {
        model.addAttribute("MenuList", menuService.findAllMenuList());
        return "navigate/global";
    }
}
