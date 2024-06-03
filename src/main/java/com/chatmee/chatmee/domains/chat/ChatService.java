package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.general.entities.ChatRoom;
import com.chatmee.chatmee.general.entities.Message;

public interface ChatService {

    ChatRoom createChat(ChatRoom chatRoom);

    Message saveMessage(Message message);
}
