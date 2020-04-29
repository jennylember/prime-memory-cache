package com.lember.primememorycache.rubbish;

import com.lember.primememorycache.PersistenceHelper;
import com.lember.primememorycache.data.HasLogin;
import com.lember.primememorycache.data.Identifiable;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
public class NoPersistenceHelper implements PersistenceHelper {

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    @Override
    public <T extends Identifiable> void save(T identifiable) {

    }

    @Override
    public void deleteAll(Class<? extends Identifiable> entityClass) {

    }

    @Override
    public <U extends Identifiable & HasLogin> void deleteAllByLogin(String login, Class<U> entityClass) {

    }

    @Override
    public <T extends Identifiable> void delete(String id, Class<T> entityClass) {

    }

    @Override
    public <T extends Identifiable> T getById(String id, Class<T> entityClass) {
        return null;
    }

    @Override
    public <U extends Identifiable & HasLogin> List<U> getAllByLogin(String login, Class<U> entityClass) {
        return null;
    }

    @Override
    public <T extends Identifiable> List<T> getAll(Class<T> entityClass) {
        return null;
    }

}
