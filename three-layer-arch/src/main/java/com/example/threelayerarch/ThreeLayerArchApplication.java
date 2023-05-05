package com.example.threelayerarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThreeLayerArchApplication {

    public static void main(String[] args) {

       ApplicationContext aplicationContext = SpringApplication.run(ThreeLayerArchApplication.class, args);
       StringService service = aplicationContext.getBean(StringService.class);
        System.out.println(service);
    }
//    @Bean
//    public StringService createStringService(){
//        return new StringService();
//    }

}
