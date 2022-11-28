package com.example.springstudy.entity.common;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Data
@SuperBuilder
public class BaseEntity {

    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    @Builder.Default
    @CreatedBy
    private String createdBy = "";

    @Column(name = "MODIFIED_DATE", nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(name = "MODIFIED_BY", nullable = false)
    @Builder.Default
    @LastModifiedBy
    private String modifiedBy = "";

}
