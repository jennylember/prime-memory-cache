package com.lember.primememorycache;

import com.lember.primememorycache.data.Identifiable;
import java.util.List;

public interface Cache<T extends Identifiable> {
    void save(String login, T identifiable);
    void deleteAll();
    void deleteAllByLogin(String login);
    void delete(String id, String login);
    T getById(String id, String login);
    List<T> getAllByLogin(String login);

}
