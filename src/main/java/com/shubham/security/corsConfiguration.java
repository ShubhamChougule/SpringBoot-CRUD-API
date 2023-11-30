package com.shubham.security;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfiguration {


    @Bean
    public Cloudinary cloudinaryConfig() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "df8m7yxcb",
                "api_key", "197714453256289",
                "api_secret", "R4GYugpqejqIDpWAzPmvUXZJwck",
                "secure", true));
    }
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://empowerlink.netlify.app/","http://localhost:3000/");
            }
        };
    }
}
