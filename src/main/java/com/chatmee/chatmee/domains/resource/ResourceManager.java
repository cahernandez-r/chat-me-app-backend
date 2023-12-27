package com.chatmee.chatmee.domains.resource;

import com.chatmee.chatmee.domains.resource.response.FindAllResourcesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.chatmee.chatmee.domains.resource.ResourceMapper.resourceToFindAllResourcesResponse;

@Component
@RequiredArgsConstructor
public class ResourceManager {

    private final ResourceService resourceService;

    public List<FindAllResourcesResponse> findAllResources() {
        return resourceToFindAllResourcesResponse(resourceService.findAll());
    }

}
