package com.chatmee.chatmee.general.repositories;

import com.chatmee.chatmee.general.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findAllByActiveTrue();
}
