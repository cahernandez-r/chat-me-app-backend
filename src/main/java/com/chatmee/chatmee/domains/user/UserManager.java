package com.chatmee.chatmee.domains.user;

import com.chatmee.chatmee.domains.user.request.CreateUserRequest;
import com.chatmee.chatmee.domains.user.request.FindPeopleRequest;
import com.chatmee.chatmee.domains.user.response.CreateUserResponse;
import com.chatmee.chatmee.domains.user.response.FindPeopleResponse;
import com.chatmee.chatmee.domains.user.response.ListFindPeopleResponse;
import com.chatmee.chatmee.general.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.chatmee.chatmee.domains.user.UserMapper.*;

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

    public ListFindPeopleResponse findPeople(final String userName, final FindPeopleRequest request) {
        Pageable page = PageRequest.of(request.getPageNumber(), request.getPageSize());
        Page<User> pagedUsers = userService.findPeople(userName, page);
        return ListFindPeopleResponse
                .builder()
                .totalElements(pagedUsers.getTotalElements())
                .users(generateListUsers(pagedUsers.getContent()))
                .build();

    }

    private List<FindPeopleResponse> generateListUsers(final List<User> users) {
        return users.stream()
                .map(UserMapper::userToFindPeopleResponse)
                .toList();
    }
}
