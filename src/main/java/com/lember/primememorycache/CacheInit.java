package com.lember.primememorycache;

import com.lember.primememorycache.data.dao.WorkspaceDao;
import com.lember.primememorycache.data.dto.Workspace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import java.util.stream.Collectors;

@Slf4j
public class CacheInit implements ApplicationListener<ApplicationReadyEvent> {

    Cache<Workspace> workspaceCache;
    PersistenceHelper persistenceHelper;

    @Autowired
    public CacheInit(Cache<Workspace> workspaceCache, PersistenceHelper persistenceHelper) {
        this.workspaceCache = workspaceCache;
        this.persistenceHelper = persistenceHelper;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent __) {
        log.info("Workspace cache init");

        persistenceHelper.getAll(WorkspaceDao.class)
                .stream()
                .collect(Collectors.groupingBy(WorkspaceDao::getLogin))
                .forEach((login, workspaceDaos) -> {
                    workspaceCache.getAllByLogin(login);
                    workspaceDaos.forEach(workspaceDao ->
                            workspaceCache.getById(workspaceDao.getLogin(), workspaceDao.getWorkspaceId()));
                });
    }
}
