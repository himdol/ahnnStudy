package com.example.springstudy.dto;

import com.example.springstudy.entity.menu.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class MenuDto {

    @Column(name = "MENU_ID")
    private String menuId;

    @Column(name = "PARENT_MENU_ID")
    private String parentMenuId;

    @Column(name = "TOP_PARENT_MENU_ID")
    private String topParentMenuId;

    @Column(name = "DEPTH")
    private int depth;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_TYPE")
    private String menuType;

    @Column(name = "LINK")
    private String link;

    @Column(name = "LINK_OPEN_TYPE")
    private String linkOpenType;

    @Column(name = "PC_EXPOSURE_TF")
    private char pcExposureTf;

    @Column(name = "MOBILE_EXPOSURE_TF")
    private char mobileExposureTf;

    @Column(name = "EXPOSURE_TF")
    private char exposureTf;

    @Column(name = "SORT")
    private int sort;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "MODIFIED_BY")
    private String  modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

    public static MenuDto entityToDto(MenuEntity menuEntity) {
        return MenuDto.builder()
                .menuId(menuEntity.getMenuId())
                .parentMenuId(menuEntity.getParentMenuId())
                .topParentMenuId(menuEntity.getTopParentMenuId())
                .depth(menuEntity.getDepth())
                .menuName(menuEntity.getMenuName())
                .menuType(menuEntity.getMenuType())
                .pcExposureTf(menuEntity.getPcExposureTf())
                .mobileExposureTf(menuEntity.getMobileExposureTf())
                .exposureTf(menuEntity.getExposureTf())
                .sort(menuEntity.getSort())
                .description(menuEntity.getDescription())
                .link(menuEntity.getLink())
                .linkOpenType(menuEntity.getLinkOpenType())
                .createdBy(menuEntity.getCreatedBy())
                .createdDate(menuEntity.getCreatedDate())
                .modifiedBy(menuEntity.getModifiedBy())
                .modifiedDate(menuEntity.getModifiedDate())
                .build();
    }

    public static List<MenuDto> entityListToDtoList(List<MenuEntity> entityList){
        return null;
    }


}
