package com.chatmee.chatmee.domains.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserRoute {

    public static final String USERS = "users";
    public static final String VALIDATE_EXIST_USER_NAME = "validateExistsUserName/{userName}";
    public static final String CREATE_USER = "createUser";
    public static final String VALIDATE_SECURITY_WORD = "validateSecurityWord/{userName}/{securityWord}";
    public static final String FIND_PEOPLE = "findPeople/{userName}";

    public static final String FETCH_INFO_USER = "fetchInfoUser/{userName}";
}
