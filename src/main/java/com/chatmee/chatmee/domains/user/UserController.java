package com.chatmee.chatmee.domains.user;

import com.chatmee.chatmee.domains.user.request.CreateUserRequest;
import com.chatmee.chatmee.domains.user.response.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(UserRoute.USERS)
public class UserController {

    private final UserManager userManager;

    @GetMapping(UserRoute.VALIDATE_EXIST_USER_NAME)
    public ResponseEntity<Boolean> validateExistsUserName(@PathVariable final String userName) {
        return  ResponseEntity.ok().body(userManager.validateExistsUserName(userName));
    }

    @PostMapping(UserRoute.CREATE_USER)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody final CreateUserRequest request) {
        return ResponseEntity.ok().body(userManager.createUser(request));
    }

    @GetMapping(UserRoute.VALIDATE_SECURITY_WORD)
    public ResponseEntity<Boolean> validateUserNameSecurityWord(@PathVariable final String userName, @PathVariable final String securityWord) {
        return ResponseEntity.ok().body(userManager.validateUserNameAndSecurityWord(userName, securityWord));
    }
}
