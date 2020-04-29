package com.lember.primememorycache.data.dao;

import com.lember.primememorycache.Utils;
import com.lember.primememorycache.data.HasLogin;
import com.lember.primememorycache.data.Identifiable;
import com.lember.primememorycache.data.dto.Workspace;
import com.lember.primememorycache.data.dto.WorkspaceWidget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "workspaces")
public class WorkspaceDao implements Identifiable, HasLogin {

    @Id
    private String id;
    private String workspaceId;
    private String login;
    private List<WorkspaceWidget> widgets;

    public Workspace toDto() {
        return new Workspace(workspaceId, widgets);
    }

    public static WorkspaceDao fromDto(String login, Workspace dto) {
        return new WorkspaceDao(Utils.composeId(dto.getId(), login), dto.getId(), login, dto.getWidgets());
    }
}
