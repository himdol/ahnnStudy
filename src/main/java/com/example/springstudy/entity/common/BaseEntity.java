package com.example.springstudy.entity.common;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createDate;

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    @CreatedBy
    private String createBy;

    @Column(name = "MODIFIED_DATE", nullable = false)
    @LastModifiedDate
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY", nullable = false)
    @LastModifiedBy
    private String modifiedBy;
}
