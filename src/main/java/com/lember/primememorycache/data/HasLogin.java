package com.lember.primememorycache.data;

import lombok.NonNull;

public interface HasLogin {

    String getLogin();

    void setLogin(@NonNull String login);
}
