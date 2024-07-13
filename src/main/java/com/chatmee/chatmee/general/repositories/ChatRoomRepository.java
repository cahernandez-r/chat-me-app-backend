package com.chatmee.chatmee.general.repositories;

import com.chatmee.chatmee.general.entities.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findByUuidChatAndActiveTrue(String uuid);

    @Query("SELECT chr FROM tbl_transmitter_receiver chr "
            + "JOIN chr.sender send "
            + "JOIN chr.recipient rec "
            + "WHERE ((send.id = ?1 AND rec.id = ?2) OR (send.id =?2 AND rec.id = ?1)) AND chr.active = true")
    Optional<ChatRoom> findBySenderAndRecipientOrRecipientAndSenderAndActiveTrue(Long idSender, Long idRecipient);
}
