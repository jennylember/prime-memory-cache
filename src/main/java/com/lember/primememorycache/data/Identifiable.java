package com.lember.primememorycache.data;

import lombok.NonNull;

public interface Identifiable {

    String getId();

    void setId(@NonNull String id);
}
