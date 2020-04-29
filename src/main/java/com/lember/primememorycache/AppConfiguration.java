package com.lember.primememorycache;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class AppConfiguration {

    String persistenceHelperClass;

    @Value("${persistenceHelperClass}")
    public void setPersistenceHelperClass(String persistenceHelperClass) {
        log.info("Use persistenceHelperClass: {}", persistenceHelperClass);
        this.persistenceHelperClass = persistenceHelperClass;
    }

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    @Bean
    @SneakyThrows
    PersistenceHelper persistenceHelper() {
        return (PersistenceHelper) Class.forName(persistenceHelperClass).getDeclaredConstructor().newInstance();

    }


}
