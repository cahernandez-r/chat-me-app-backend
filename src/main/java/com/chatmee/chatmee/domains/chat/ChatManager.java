package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.domains.chat.request.MessageRequest;
import com.chatmee.chatmee.general.entities.ChatRoom;
import com.chatmee.chatmee.general.entities.Message;
import com.chatmee.chatmee.general.entities.User;
import com.chatmee.chatmee.general.repositories.ChatRoomRepository;
import com.chatmee.chatmee.general.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatManager {

    private final ChatService chatService;
    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;

    public String createChat(final Long idSender, final Long idRecipient) {
        final User sender = userRepository.findByIdAndActiveTrue(idSender).orElseThrow();
        final User recipient = userRepository.findByIdAndActiveTrue(idRecipient).orElseThrow();
        final ChatRoom chatRoomToCreate = ChatMapper.createNewChat(sender, recipient);
        final ChatRoom chatRoomCreated = chatService.createChat(chatRoomToCreate);

        return chatRoomCreated.getUuidChat();
    }

    public void saveMessage(final MessageRequest messageRequest) {
        final ChatRoom chatRoom = chatRoomRepository.findByUuidChatAndActiveTrue(messageRequest.uuidChat()).orElseThrow();
        final Message message = new Message();
        message.setChatRoom(chatRoom);
        message.setMessage(message.getMessage());
    }
}
