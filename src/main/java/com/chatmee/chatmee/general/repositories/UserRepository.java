package com.chatmee.chatmee.general.repositories;

import com.chatmee.chatmee.general.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsUserByUserNameAndActiveTrue(String userName);

    User findByUserNameAndActiveTrue(String userName);
}
