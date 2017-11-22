package com.teamtreehouse.cotw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class CountriesOfTheWorld {
    public static void main(String[] args) {
        SpringApplication.run(CountriesOfTheWorld.class, args);
    }
}
