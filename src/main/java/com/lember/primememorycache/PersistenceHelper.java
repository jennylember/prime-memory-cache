package com.lember.primememorycache;


import com.lember.primememorycache.data.HasLogin;
import com.lember.primememorycache.data.Identifiable;

import java.util.List;

public interface PersistenceHelper {

    <T extends Identifiable>  void save(T identifiable);
    void deleteAll(Class<? extends Identifiable> entityClass);
    <U extends Identifiable & HasLogin> void deleteAllByLogin(String login, Class<U> entityClass);
    <T extends Identifiable> void delete(String id, Class<T> entityClass);
    <T extends Identifiable> T getById(String id, Class<T> entityClass);
    <U extends Identifiable & HasLogin> List<U> getAllByLogin(String login, Class<U> entityClass);
    <T extends Identifiable> List<T> getAll(Class<T> entityClass);
}
