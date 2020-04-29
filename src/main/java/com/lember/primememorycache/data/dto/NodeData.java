package com.lember.primememorycache.data.dto;

import java.util.List;

public interface NodeData {
    List<NodeData> getChildren();

    void setChildren(List<NodeData> var1);

    String getId();

    void setId(String var1);

    LocaleItemData getName();

    void setName(LocaleItemData var1);
}
