package com.chatmee.chatmee.domains.user;

import com.chatmee.chatmee.domains.user.request.CreateUserRequest;
import com.chatmee.chatmee.domains.user.response.CreateUserResponse;
import com.chatmee.chatmee.domains.user.response.FindPeopleResponse;
import com.chatmee.chatmee.general.entities.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {

    public static User createUserRequestToUser(final CreateUserRequest userToCreate) {
        return User.builder()
                .userName(userToCreate.getUserName())
                .active(Boolean.TRUE)
                .securityWord(userToCreate.getSecurityWord())
                .build();
    }

    public static CreateUserResponse userToCreateUserResponse(final User user) {
        return CreateUserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .securityWord(user.getSecurityWord())
                .build();
    }

    public static FindPeopleResponse userToFindPeopleResponse(final User user) {
        return FindPeopleResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .build();
    }
}
