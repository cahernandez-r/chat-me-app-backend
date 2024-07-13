package com.chatmee.chatmee.domains.chat.request;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateChatRoomRequest(
        @NonNull
        Long idSender,

        @NonNull
        Long idRecipient
) {
}
