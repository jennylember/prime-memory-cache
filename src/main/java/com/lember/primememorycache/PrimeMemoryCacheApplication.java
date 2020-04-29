package com.lember.primememorycache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
@Slf4j
public class PrimeMemoryCacheApplication {

    @PostConstruct
    private void postConstruct() {
        log.info("Initialized");
    }

    public static void main(String[] args) {

    	SpringApplication.run(PrimeMemoryCacheApplication.class, args);
		System.out.println("Hello");
    }


}
