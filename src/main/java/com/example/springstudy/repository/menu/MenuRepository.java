package com.example.springstudy.repository.menu;

import com.example.springstudy.entity.menu.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, String> {

    @Query(value = "WITH RECURSIVE GET_MENU (menu_id, menu_name, depth, parent, sort) AS(" +
            "    SELECT" +
            "        m.menu_id, m.menu_name, m.depth, m.parent_menu_id, m.sort" +
            "    FROM menu m" +
            "    UNION" +
            "    SELECT" +
            "        sm.menu_id, sm.menu_name, sm.depth, sm.parent_menu_id, sm.sort" +
            "    FROM menu sm" +
            "            INNER JOIN GET_MENU" +
            "            ON      sm.parent_menu_id = GET_MENU.menu_id)" +
            "SELECT * FROM GET_MENU" +
            "ORDER BY GET_MENU.parent, GET_MENU.menu_id, GET_MENU.sort", nativeQuery = true)
    List<MenuEntity> findAllMenuList();
    
}
