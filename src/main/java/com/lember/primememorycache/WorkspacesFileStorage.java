package com.lember.primememorycache;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lember.primememorycache.data.dto.Workspace;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;
//
//@Slf4j
//public class WorkspacesFileStorage extends FileStorage<Workspace> {
//
//    protected WorkspacesFileStorage(@NonNull File parentDir) throws IOException {
//        super(parentDir);
//    }
//
//    @Override
//    public @NonNull String getFileName() {
//        return FileWidgetRepository.WORKSPACES_FILE_NAME;
//    }
//
//    @NonNull
//    @Override
//    protected List<Workspace> parseJsonContent(@NonNull String json) {
//        return Json.toObjectOrFail(json, new TypeReference<List<Workspace>>() {});
//    }
//}