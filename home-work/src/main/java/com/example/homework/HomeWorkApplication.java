package com.example.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeWorkApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(HomeWorkApplication.class, args);
        HomeWorkService service = applicationContext.getBean(HomeWorkService.class);

    }
    @Bean
    public HomeWorkService createHomeWorkService(){
        return new HomeWorkService();
    }
}
