package com.promition.drugwiki.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;

    @PrePersist
    public void beforeInsert() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = new Date();
    }
}
