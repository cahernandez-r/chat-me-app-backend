package com.chatmee.chatmee.domains.chat;

import com.chatmee.chatmee.domains.chat.model.ChatNotification;
import com.chatmee.chatmee.domains.chat.request.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(ChatRoute.CHATS)
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatManager chatManager;

    @MessageMapping("/chat-{userName}")
    public void processMessage(@Payload MessageRequest messageRequest, @DestinationVariable String userName) {
        //chatManager.saveMessage(messageRequest);
        messagingTemplate.convertAndSend(String.format("/queue/messages-%s", userName),
                messageRequest);

    }

    @PostMapping(ChatRoute.CREATE_CHAT)
    public ResponseEntity<String> createChat(@PathVariable final Long idSender, @PathVariable final Long idRecipient) {
        return ResponseEntity.ok(chatManager.createChat(idSender, idRecipient));
    }

}
