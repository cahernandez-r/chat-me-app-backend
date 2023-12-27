package com.chatmee.chatmee.domains.user;

import com.chatmee.chatmee.general.entities.User;

public interface UserService {

    Boolean validateUserNameExists(String userName);

    User createUser(User user);

    User getUserByUserName(String userName);
}
