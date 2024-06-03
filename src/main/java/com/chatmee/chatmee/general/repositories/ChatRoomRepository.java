package com.chatmee.chatmee.general.repositories;

import com.chatmee.chatmee.general.entities.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
