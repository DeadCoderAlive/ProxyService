package edu.njit.ProxyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by srinivaz on 4/24/16.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void  main(String[] args) {


        SpringApplication.run(Application.class,args);


    }
}
