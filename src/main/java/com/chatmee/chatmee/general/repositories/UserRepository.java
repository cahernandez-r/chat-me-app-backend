package com.chatmee.chatmee.general.repositories;

import com.chatmee.chatmee.general.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsUserByUserNameAndActiveTrue(String userName);

    User findByUserNameAndActiveTrue(String userName);

    Page<User> findAllByActiveTrueAndUserNameIsNot(String userName, Pageable page);

    Optional<User> findByIdAndActiveTrue(Long id);
}
