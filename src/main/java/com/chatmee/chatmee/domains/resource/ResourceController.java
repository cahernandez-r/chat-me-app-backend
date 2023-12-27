package com.chatmee.chatmee.domains.resource;

import com.chatmee.chatmee.domains.resource.response.FindAllResourcesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(ResourceRoute.RESOURCES)
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceManager resourceManager;

    @GetMapping(ResourceRoute.GET_RESOURCES)
    public ResponseEntity<List<FindAllResourcesResponse>> findAllResources() {
        return ResponseEntity.ok().body(resourceManager.findAllResources());
    }
}
