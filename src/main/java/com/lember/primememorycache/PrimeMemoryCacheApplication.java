package com.lember.primememorycache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PrimeMemoryCacheApplication {

    public static void main(String[] args) {

    	SpringApplication.run(PrimeMemoryCacheApplication.class, args);
		System.out.println("Hello");

    }


}
