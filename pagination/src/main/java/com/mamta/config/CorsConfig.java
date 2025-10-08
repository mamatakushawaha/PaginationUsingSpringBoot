package com.mamta.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")              // allow all endpoints
                        .allowedOrigins("http://localhost:4200") // allow Angular dev server
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // allowed HTTP methods
                        .allowedHeaders("*")           // allow all headers
                        .allowCredentials(true);       // allow cookies/auth headers
            }
        };
    }
}
