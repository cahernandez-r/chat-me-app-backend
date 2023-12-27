package com.chatmee.chatmee.domains.resource;

import com.chatmee.chatmee.general.entities.Resource;
import com.chatmee.chatmee.general.repositories.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService{

    private final ResourceRepository resourceRepository;
    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAllByActiveTrue();
    }
}
