package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.domains.chat.request.MessageRequest;
import com.chatmee.chatmee.domains.chat.request.UserExistsInChatRoomResponse;
import com.chatmee.chatmee.domains.chat.response.CreateChatRoomResponse;
import com.chatmee.chatmee.general.dtos.MessageDTO;
import com.chatmee.chatmee.general.entities.ChatRoom;
import com.chatmee.chatmee.general.entities.Message;
import com.chatmee.chatmee.general.entities.User;
import com.chatmee.chatmee.general.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class ChatManager {

    private final ChatService chatService;
    private final UserRepository userRepository;

    public CreateChatRoomResponse createChat(final Long idSender, final Long idRecipient) {
        final User sender = userRepository.findByIdAndActiveTrue(idSender).orElseThrow();
        final User recipient = userRepository.findByIdAndActiveTrue(idRecipient).orElseThrow();
        final ChatRoom chatRoomToCreate = ChatMapper.createNewChat(sender, recipient);
        final ChatRoom chatRoomCreated = chatService.createChat(chatRoomToCreate);

        return new CreateChatRoomResponse(chatRoomCreated.getUuidChat());
    }

    public UserExistsInChatRoomResponse userExistsInChatRoom(final Long idSender, final Long idRecipient) {
        final Optional<ChatRoom> opChatRoom = chatService.findChatRoomByIdSenderAndIdRecipient(idSender, idRecipient);
        if (opChatRoom.isPresent()) {
            final ChatRoom chatRoom = opChatRoom.get();
            final List<MessageDTO> messages = chatRoom.getMessages().stream()
                    .map((x)->
                            MessageDTO
                                    .builder()
                                    .idRecipient(x.getRecipient().getId())
                                    .idSender(x.getSender().getId())
                                    .message(x.getMessage())
                                    .createdAt(x.getCreationDate())
                            .build()
                    ).sorted(Comparator.comparing(MessageDTO::getCreatedAt))
                    .toList();
            return new UserExistsInChatRoomResponse(Boolean.TRUE, chatRoom.getUuidChat(), messages);
        }
        return new UserExistsInChatRoomResponse(Boolean.FALSE, null, null);
    }

    public void saveMessage(final MessageRequest messageRequest) {
        final ChatRoom chatRoom = chatService.findByUuidChatAndActiveTrue(messageRequest.uuidChat()).orElseThrow();
        final User sender = userRepository.findByIdAndActiveTrue(messageRequest.idSender()).orElseThrow();
        final User recipient = userRepository.findByIdAndActiveTrue(messageRequest.idRecipient()).orElseThrow();
        final Message message = new Message();
        message.setChatRoom(chatRoom);
        message.setMessage(messageRequest.message());
        message.setSender(sender);
        message.setRecipient(recipient);
        message.setCreationDate(new Date());
        chatService.saveMessage(message);
    }
}
