package com.chatmee.chatmee.domains.chat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ChatRoute {

    public static final String CHATS = "chats";
    public static final String CREATE_CHAT = "save/{idSender}/{idRecipient}";
}
