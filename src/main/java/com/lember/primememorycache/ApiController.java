package com.lember.primememorycache;

import com.lember.primememorycache.data.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.lember.primememorycache.data.Workspace;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ApiController {


    Requests memoryCache;
    CacheManager cacheManager;

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    @Autowired
    public ApiController(Requests memoryCache, CacheManager cacheManager) {
        this.memoryCache = memoryCache;
        this.cacheManager = cacheManager;
    }


    @GetMapping("/workspace")
    public Workspace getWorkspaceById(@RequestParam(name = "id") String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
       return memoryCache.getWorkspaceById(id);

    }

    @PostMapping("/save")
    public void saveWorkspace(@RequestBody Workspace workspace) {
        memoryCache.saveWorkspace(workspace);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        memoryCache.deleteAll();
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam String id) {
        memoryCache.deleteById(id);
    }



}
