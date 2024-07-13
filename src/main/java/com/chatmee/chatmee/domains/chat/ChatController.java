package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.domains.chat.request.CreateChatRoomRequest;
import com.chatmee.chatmee.domains.chat.request.MessageRequest;
import com.chatmee.chatmee.domains.chat.request.UserExistsInChatRoomResponse;
import com.chatmee.chatmee.domains.chat.response.CreateChatRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(ChatRoute.CHATS)
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatManager chatManager;

    @MessageMapping(ChatRoute.CHAT)
    public void processMessage(@Payload MessageRequest messageRequest, @DestinationVariable String userName) {
        chatManager.saveMessage(messageRequest);
        messagingTemplate.convertAndSend(String.format("/queue/messages-%s", userName),
                messageRequest);

    }

    @PostMapping(ChatRoute.CREATE_CHAT)
    public ResponseEntity<CreateChatRoomResponse> createChat(@RequestBody CreateChatRoomRequest request) {
        return ResponseEntity.ok(chatManager.createChat(request.idSender(), request.idRecipient()));
    }

    @GetMapping(ChatRoute.EXISTS)
    public ResponseEntity<UserExistsInChatRoomResponse> userExistsInChatRoom(@PathVariable final Long idSender,
                                                                             @PathVariable final Long idRecipient){
        return ResponseEntity.ok(chatManager.userExistsInChatRoom(idSender, idRecipient));
    }
}
