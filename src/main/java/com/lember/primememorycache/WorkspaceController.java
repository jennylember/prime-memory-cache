package com.lember.primememorycache;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.lember.primememorycache.data.dto.Workspace;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RestController
public class WorkspaceController {

    Cache<Workspace> workspaceCache;
    CacheManager cacheManager;

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    @Autowired
    public WorkspaceController(Cache<Workspace> workspaceCache, CacheManager cacheManager) {
        this.workspaceCache = workspaceCache;
        this.cacheManager = cacheManager;
    }

    @GetMapping("/workspace")
    public Workspace getWorkspaceById(@RequestParam(name = "id") String id,
                                      @RequestParam(name = "login") String login) {
        log.info("/workspace {} {}", id, login);

        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(login)) {
            return null;
        }

        return Utils.log(workspaceCache.getById(id, login), "/workspace response:");
    }

    @GetMapping("/workspaces")
    public List<Workspace> getWorkspaces(@RequestParam(name = "login") String login) {
        log.info("/workspaces {}", login);
        if (StringUtils.isEmpty(login)) {
            return null;
        }
        return Utils.log(workspaceCache.getAllByLogin(login), "/workspaces response:");
    }


    @PostMapping("/save")
    public void saveWorkspace(@RequestParam(name = "login") String login, @RequestBody Workspace workspace) {
        log.info("/save {} {}", login, workspace);
        if (StringUtils.isEmpty(login) || workspace == null) {
            return;
        }
        workspaceCache.save(login, workspace);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        log.info("/deleteAll");
        workspaceCache.deleteAll();
    }

    @DeleteMapping("/deleteByLogin")
    public void deleteAllByLogin(@RequestParam(name = "login") String login) {
        log.info("/deleteAll {}", login);
        if (StringUtils.isEmpty(login)) {
            return;
        }
        workspaceCache.deleteAllByLogin(login);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam(name = "id") String id, @RequestParam(name = "login") String login) {
        log.info("/delete {} {}", id, login);
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(login)) {
            return;
        }
        workspaceCache.delete(id, login);
    }




}
