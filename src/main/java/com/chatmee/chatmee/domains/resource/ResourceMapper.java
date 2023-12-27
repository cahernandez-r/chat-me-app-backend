package com.chatmee.chatmee.domains.resource;

import com.chatmee.chatmee.domains.resource.response.FindAllResourcesResponse;
import com.chatmee.chatmee.general.entities.Resource;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceMapper {

    public static List<FindAllResourcesResponse> resourceToFindAllResourcesResponse(List<Resource> resources) {
        return resources.stream().map(resource -> FindAllResourcesResponse
                .builder()
                .icon(resource.getIcon())
                .label(resource.getDescription())
                .code(resource.getCode())
                .routerLink(resource.getRoute())
                .build())
                .toList();
    }
}
