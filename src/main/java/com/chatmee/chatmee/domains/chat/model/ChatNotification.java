package com.chatmee.chatmee.domains.chat.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChatNotification {

    private String uuidChat;
    private Long senderId;
    private Long recipientId;
    private String content;
}
