package com.chatmee.chatmee.domains.user;

import com.chatmee.chatmee.domains.user.request.CreateUserRequest;
import com.chatmee.chatmee.domains.user.response.CreateUserResponse;
import com.chatmee.chatmee.general.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.chatmee.chatmee.domains.user.UserMapper.createUserRequestToUser;
import static com.chatmee.chatmee.domains.user.UserMapper.userToCreateUserResponse;

@Component
@RequiredArgsConstructor
public class UserManager {

    final UserService userService;

    public Boolean validateExistsUserName(final String userName) {
        return userService.validateUserNameExists(userName);
    }

    public CreateUserResponse createUser(CreateUserRequest userToCreate) {
        final User user = createUserRequestToUser(userToCreate);
        return userToCreateUserResponse(userService.createUser(user));
    }

    public Boolean validateUserNameAndSecurityWord(final String userName, final String securityWord) {
        final User user = userService.getUserByUserName(userName);
        return user.getSecurityWord().equals(securityWord);
    }
}
