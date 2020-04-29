package com.lember.primememorycache.rubbish;

import com.lember.primememorycache.data.dto.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkspaceRepository extends MongoRepository<Workspace, String> {


}
