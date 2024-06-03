package com.chatmee.chatmee.general.repositories;

import com.chatmee.chatmee.general.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
