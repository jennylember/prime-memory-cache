package com.lember.primememorycache.data.dto;

import com.lember.primememorycache.data.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workspace implements Identifiable {

    private String id;
    private List<WorkspaceWidget> widgets;
}
