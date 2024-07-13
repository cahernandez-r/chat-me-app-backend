package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.general.entities.ChatRoom;
import com.chatmee.chatmee.general.entities.Message;
import com.chatmee.chatmee.general.repositories.ChatRoomRepository;
import com.chatmee.chatmee.general.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public void saveMessage(final Message message) {
        messageRepository.save(message);
    }

    @Override
    public Optional<ChatRoom> findChatRoomByIdSenderAndIdRecipient(final Long idSender, final Long idRecipient) {
        return chatRoomRepository.findBySenderAndRecipientOrRecipientAndSenderAndActiveTrue(idSender, idRecipient);
    }

    @Override
    public Optional<ChatRoom> findByUuidChatAndActiveTrue(final String uuid) {
        return chatRoomRepository.findByUuidChatAndActiveTrue(uuid);
    }
}
