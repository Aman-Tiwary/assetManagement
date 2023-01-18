package com.case_study.Project2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer{
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping(("/**"))
                .allowedMethods("*")
                .allowedOrigins("*");
            }
    }
