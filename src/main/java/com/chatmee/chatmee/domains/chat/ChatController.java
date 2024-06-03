package com.chatmee.chatmee.domains.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(ChatRoute.CHATS)
public class ChatController {

    private final ChatManager chatManager;

    @PostMapping(ChatRoute.CREATE_CHAT)
    public ResponseEntity<String> createChat(@PathVariable final Long idSender, @PathVariable final Long idRecipient) {
        return ResponseEntity.ok(chatManager.createChat(idSender, idRecipient));
    }

}
