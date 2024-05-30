package com.chatmee.chatmee.general.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbl_transmitter_receiver")
public class TransmitterReceiver extends EntityPrincipal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sec_transmitter_receiver")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sec_transmitter")
    private User transmitter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sec_receiver")
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sec_chat")
    private Chat chat;
}
