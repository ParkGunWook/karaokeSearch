package com.example.karaokesearch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GpConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry cr) {
        cr.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:8080")  // 허용할 주소 및 포트
                .allowedOrigins("http://localhost:8080");  // 허용할 주소 및 포트
    }
}
