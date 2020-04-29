package com.lember.primememorycache;

import com.lember.primememorycache.data.dao.WorkspaceDao;
import com.lember.primememorycache.data.dto.Workspace;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Slf4j
public class WorkspaceCache implements Cache<Workspace> {


    PersistenceHelper persistenceHelper;
    @Autowired
    CacheManager cacheManager;


    public WorkspaceCache(PersistenceHelper persistenceHelper) {
        this.persistenceHelper = persistenceHelper;
    }

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    @Override
    @CacheEvict(value = "workspace", allEntries = true)
    public void save(String login, Workspace workspace) {
        WorkspaceDao dao = WorkspaceDao.fromDto(login, workspace);
        persistenceHelper.save(dao);
    }

    @Override
    @CacheEvict(value = "workspace", allEntries = true)
    public void deleteAll() {
        persistenceHelper.deleteAll(WorkspaceDao.class);
    }

    @Override
    @CacheEvict(value = "workspace", allEntries = true)
    public void deleteAllByLogin(String login) {
        persistenceHelper.deleteAllByLogin(login, WorkspaceDao.class);
    }

    @Override
    @CacheEvict(value = "workspace", key = "#id.concat('-').concat(#login)")
    public void delete(@NonNull String id, @NonNull String login) {
        persistenceHelper.delete(Utils.composeId(id, login), WorkspaceDao.class);
    }

    @Override
    @Nullable
    @Cacheable(value = "workspace", key = "#id.concat('-').concat(#login)")
    public Workspace getById(@NonNull String id, @NonNull String login) {
        WorkspaceDao dao = persistenceHelper.getById(Utils.composeId(id, login), WorkspaceDao.class);
        if (dao == null) {
            return null;
        }
        return dao.toDto();
    }

    @Override
    @Cacheable(value = "workspace", key = "#login")
    public List<Workspace> getAllByLogin(String login) {
        return persistenceHelper.getAllByLogin(login, WorkspaceDao.class)
                .stream()
                .map(WorkspaceDao::toDto)
                .collect(Collectors.toList());
    }


}
