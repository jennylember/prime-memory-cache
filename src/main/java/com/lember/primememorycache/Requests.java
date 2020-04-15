package com.lember.primememorycache;

import com.lember.primememorycache.data.Workspace;


import java.util.List;

public interface Requests {
    Workspace saveWorkspace(Workspace workspace);
    void deleteAll();
    void deleteById(String id);
    Workspace getWorkspaceById(String id);
    List<Workspace> getWorkspaces();
}
