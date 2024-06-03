package com.chatmee.chatmee.domains.chat.request;

public record MessageRequest(
        String uuidChat,
        Long idSender,
        Long idRecipient,
        String message
) {
}
