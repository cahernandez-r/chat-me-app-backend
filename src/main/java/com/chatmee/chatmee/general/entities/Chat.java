package com.chatmee.chatmee.general.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tbl_chat")
public class Chat extends EntityPrincipal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sec_chat")
    private Long id;

    @Column(name = "json_chat")
    private String jsonChat;
}
