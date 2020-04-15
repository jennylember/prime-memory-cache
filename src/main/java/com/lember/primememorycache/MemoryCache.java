package com.lember.primememorycache;

import com.lember.primememorycache.data.Workspace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.*;


@Component
@Slf4j
public class MemoryCache implements Requests {

    @Autowired
    private WorkspaceRepository repository;

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    @Override
    @CachePut (value = "cache", key="#workspace.id", condition = "#workspace != null")
    public Workspace saveWorkspace(Workspace workspace) {
        return repository.save(workspace);
    }

    @CacheEvict(value = "cache", allEntries = true)
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @CacheEvict(value = "cache", key = "#id")
    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    @Cacheable(value = "cache", key="#id")
    public Workspace getWorkspaceById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Cacheable
    public List<Workspace> getWorkspaces() {
        return Collections.emptyList();
    }
}
