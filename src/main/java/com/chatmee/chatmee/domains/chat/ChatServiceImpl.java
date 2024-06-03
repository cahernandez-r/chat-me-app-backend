package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.general.entities.ChatRoom;
import com.chatmee.chatmee.general.entities.Message;
import com.chatmee.chatmee.general.repositories.ChatRoomRepository;
import com.chatmee.chatmee.general.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final MessageRepository messageRepository;

    @Override
    public ChatRoom createChat(final ChatRoom chatRoom) {

        return chatRoomRepository.save(chatRoom);
    }

    @Override
    public Message saveMessage(final Message message) {
        return messageRepository.save(message);
    }
}
