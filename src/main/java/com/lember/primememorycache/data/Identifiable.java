package com.lember.primememorycache.data;

import lombok.NonNull;

public interface Identifiable {
    /**
     * @return id
     */
    String getId();

    /**
     * @param id - идентификатор
     */
    void setId(@NonNull String id);
}
