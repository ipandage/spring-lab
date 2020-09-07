package com.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
    public CleanAir cleanAir() {
        return new CleanAir();
    }

    @Bean
    public DirtyAir dirtyAir() {
        return new DirtyAir();
    }

    @Bean
    public Person person() {
        return new Person(dirtyAir());
    }
}
    
   

