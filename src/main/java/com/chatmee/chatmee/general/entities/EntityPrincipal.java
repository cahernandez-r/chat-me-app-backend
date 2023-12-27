package com.chatmee.chatmee.general.entities;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class EntityPrincipal {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", insertable = false, updatable = false)
    private Date creationDate;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "creation_id_user")
    private User creationUser;

    @PrePersist
    @PreUpdate
    public void setDefaultActiveValue() {
        if (active == null)
            active = Boolean.TRUE;
    }
}
