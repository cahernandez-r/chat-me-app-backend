package com.chatmee.chatmee.general.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MessageDTO {
    String uuidChat;
    Long idSender;
    Long idRecipient;
    String message;
    Date createdAt;
}
