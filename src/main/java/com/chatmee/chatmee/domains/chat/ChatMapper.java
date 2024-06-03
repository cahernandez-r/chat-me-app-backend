package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.general.entities.ChatRoom;
import com.chatmee.chatmee.general.entities.Message;
import com.chatmee.chatmee.general.entities.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ChatMapper {

    public static ChatRoom createNewChat(final User sender, final User recipient) {
        final String uuid = UUID.randomUUID().toString();
        return ChatRoom.builder()
                .sender(sender)
                .recipient(recipient)
                .uuidChat(uuid)
                .build();
    }
}
