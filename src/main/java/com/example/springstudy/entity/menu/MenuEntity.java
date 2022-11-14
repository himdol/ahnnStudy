package com.example.springstudy.entity.menu;

import com.example.springstudy.dto.MenuDto;
import com.example.springstudy.entity.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity(name = "MENU")
@Table(name = "MENU")
@RequiredArgsConstructor
@Getter
@SuperBuilder
public class MenuEntity extends BaseEntity {

    @Id
    @Column(name = "MENU_ID", nullable = false)
    private String menuId;

    @Column(name = "PARENT_MENU_ID")
    private String parentMenuId;

    @Column(name = "TOP_PARENT_MENU_ID")
    private String topParentMenuId;

    @Builder.Default
    @Column(name = "DEPTH", nullable = false)
    private int depth = 1;

    @Builder.Default
    @Column(name = "MENU_NAME", nullable = false)
    private String menuName = "";

    @Builder.Default
    @Column(name = "MENU_TYPE", nullable = false)
    private String menuType = "";

    @Column(name = "LINK")
    private String link;

    @Column(name = "LINK_OPEN_TYPE")
    private String linkOpenType;

    @Builder.Default
    @Column(name = "PC_EXPOSURE_TF", nullable = false)
    private char pcExposureTf = 'T';

    @Builder.Default
    @Column(name = "MOBILE_EXPOSURE_TF", nullable = false)
    private char mobileExposureTf = 'T';

    @Builder.Default
    @Column(name = "EXPOSURE_TF", nullable = false)
    private char exposureTf = 'T';

    @Builder.Default
    @Column(name = "SORT", nullable = false)
    private int sort = 1;

    @Column(name = "DESCRIPTION")
    private String description;

    public static MenuEntity dtoToEntity(MenuDto menuDto) {
        return MenuEntity.builder()
                .menuId(menuDto.getMenuId())
                .parentMenuId(menuDto.getParentMenuId())
                .topParentMenuId(menuDto.getTopParentMenuId())
                .depth(menuDto.getDepth())
                .menuName(menuDto.getMenuName())
                .menuType(menuDto.getMenuType())
                .pcExposureTf(menuDto.getPcExposureTf())
                .mobileExposureTf(menuDto.getMobileExposureTf())
                .exposureTf(menuDto.getExposureTf())
                .sort(menuDto.getSort())
                .description(menuDto.getDescription())
                .link(menuDto.getLink())
                .linkOpenType(menuDto.getLinkOpenType())
                .createdBy(menuDto.getCreatedBy())
                .createdDate(LocalDateTime.now())
                .modifiedBy(menuDto.getModifiedBy())
                .modifiedDate(LocalDateTime.now())
                .build();
    }

}
