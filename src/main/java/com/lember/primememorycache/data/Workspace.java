package com.lember.primememorycache.data;

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
public class Workspace implements Identifiable {

    @Id
    private String id;
    private List<WorkspaceWidget> widgets;
}
