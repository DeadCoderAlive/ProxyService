package edu.njit.ProxyService;


import edu.njit.ProxyService.repository.LiveUserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



/**
 * Created by srinivaz on 4/24/16.
 */
@Configuration
@SpringBootApplication
@EnableMongoRepositories("edu.njit.ProxyService")
public class Application {

    public static void  main(String[] args) {

        SpringApplication.run(Application.class,args);


    }
@Bean
    public WebMvcConfigurerAdapter corsConfigurer(){

    return new WebMvcConfigurerAdapter() {
        @Override
        public void addCorsMappings(CorsRegistry corsRegistry){
            corsRegistry.addMapping("/**").allowedOrigins("*");

        }
    };
}


}
