package com.chatmee.chatmee.domains.chat.request;

import com.chatmee.chatmee.general.dtos.MessageDTO;
import com.chatmee.chatmee.general.entities.Message;

import java.util.List;

public record UserExistsInChatRoomResponse(
        Boolean existChat,
        String uuidChat,
        List<MessageDTO> messages
) {
}
