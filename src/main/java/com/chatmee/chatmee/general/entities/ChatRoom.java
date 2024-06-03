package com.chatmee.chatmee.general.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "tbl_transmitter_receiver")
public class ChatRoom extends EntityPrincipal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sec_chat_room")
    private Long id;

    @Column(name = "uuid_chat")
    private String uuidChat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sec_sender")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sec_recipient")
    private User recipient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chatRoom")
    @JoinColumn(name = "sec_message")
    private List<Message> message;
}
