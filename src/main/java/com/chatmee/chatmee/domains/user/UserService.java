package com.chatmee.chatmee.domains.user;

import com.chatmee.chatmee.general.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Boolean validateUserNameExists(String userName);

    User createUser(User user);

    User getUserByUserName(String userName);

    Page<User> findPeople(String userName, Pageable page );

    User fetchInfoUser(String userName);
}
