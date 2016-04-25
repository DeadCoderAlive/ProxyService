package edu.njit.ProxyService;


import edu.njit.ProxyService.repository.LiveUserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * Created by srinivaz on 4/24/16.
 */

@SpringBootApplication
@EnableMongoRepositories("edu.njit.ProxyService")
public class Application {

    public static void  main(String[] args) {

        SpringApplication.run(Application.class,args);


    }
}
