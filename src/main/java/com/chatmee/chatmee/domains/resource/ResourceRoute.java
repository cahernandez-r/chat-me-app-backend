package com.chatmee.chatmee.domains.resource;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceRoute {

    public static final String RESOURCES = "resources";
    public static final String GET_RESOURCES ="findAll";
}
