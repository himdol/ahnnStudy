package com.example.springstudy.repository.menu;

import com.example.springstudy.entity.menu.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, String> {

    @Query(value = "WITH RECURSIVE GET_MENU(menu_id, parent_menu_id, top_parent_menu_id, depth, menu_name, menu_type, link, link_open_type, pc_exposure_tf, mobile_exposure_tf, exposure_tf, sort, description, created_by, created_date, modified_by, modified_date) AS\n" +
            "    (\n" +
            "SELECT        m.menu_id, m.parent_menu_id, m.top_parent_menu_id, m.depth, m.menu_name, m.menu_type, m.link, m.link_open_type, m.pc_exposure_tf, m.mobile_exposure_tf, m.exposure_tf, m.sort, m.description, m.created_by, m.created_date, m.modified_by, m.modified_date\n" +
            "FROM menu m\n" +
            "UNION\n" +
            "SELECT        sm.menu_id, sm.parent_menu_id, sm.top_parent_menu_id, sm.depth, sm.menu_name, sm.menu_type, sm.link, sm.link_open_type, sm.pc_exposure_tf, sm.mobile_exposure_tf, sm.exposure_tf, sm.sort, sm.description, sm.created_by, sm.created_date, sm.modified_by, sm.modified_date\n" +
            "FROM menu sm\n" +
            "    INNER JOIN GET_MENU\n" +
            "        ON      sm.parent_menu_id = GET_MENU.menu_id)\n" +
            "SELECT * FROM GET_MENU ORDER BY GET_MENU.parent_menu_id, GET_MENU.menu_id, GET_MENU.sort", nativeQuery = true)
    List<MenuEntity> findAllMenuList();
    
}
