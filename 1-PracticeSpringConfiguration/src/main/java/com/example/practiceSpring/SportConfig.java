package com.example.practiceSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // tells spring that it is java configuration anf follow appropriate rules in this config file
//@ComponentScan("com.example.practiceSpring") //enables component scan and finds all classes that have @Component, register them in spring container. Here, we are using java class to do config.
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define bean for sadFortuneService
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    //define bean for swimCoach and inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
