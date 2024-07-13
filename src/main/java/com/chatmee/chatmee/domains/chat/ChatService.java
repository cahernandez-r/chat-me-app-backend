package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.general.entities.ChatRoom;
import com.chatmee.chatmee.general.entities.Message;

import java.util.Optional;

public interface ChatService {

    ChatRoom createChat(ChatRoom chatRoom);

    void saveMessage(Message message);

    Optional<ChatRoom> findChatRoomByIdSenderAndIdRecipient(Long idSender, Long idRecipient);

    Optional<ChatRoom> findByUuidChatAndActiveTrue(String uuid);
}
