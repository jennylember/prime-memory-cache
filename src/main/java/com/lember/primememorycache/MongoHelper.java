package com.lember.primememorycache;

import com.lember.primememorycache.data.HasLogin;
import com.lember.primememorycache.data.Identifiable;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
public class MongoHelper implements PersistenceHelper {

    MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    @Override
    public <T extends Identifiable> void save(T identifiable) {
        mongoTemplate.save(identifiable);
    }

    @Override
    public void deleteAll(Class<? extends Identifiable> entityClass) {
        mongoTemplate.dropCollection(entityClass);
    }

    @Override
    public <U extends Identifiable & HasLogin> void deleteAllByLogin(String login, Class<U> entityClass) {
        Query query = new Query();
        query.addCriteria(Criteria.where("login").is(login));
        mongoTemplate.remove(query, entityClass);
    }

    @Override
    public  <T extends Identifiable> void delete(String id, Class<T> entityClass) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, entityClass);
    }

    @Nullable
    @Override
    public <T extends Identifiable> T getById(String id, Class<T> entityClass) {
        return mongoTemplate.findById(id, entityClass);
    }

    @Override
    public <U extends Identifiable & HasLogin> List<U> getAllByLogin(String login, Class<U> entityClass) {
        Query query = new Query();
        query.addCriteria(Criteria.where("login").is(login));
        return mongoTemplate.find(query, entityClass);
    }

    @Override
    public <T extends Identifiable> List<T> getAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

}
