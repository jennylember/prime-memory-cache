package com.lember.primememorycache;

import com.lember.primememorycache.data.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkspaceRepository extends MongoRepository<Workspace, String> {

   // void saveWorkspace(Workspace workspace);

  //  Workspace getWorkspaceById(String id);

    //List<Workspace> getWorkspaces();
}
