package org.vedy.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebServicesApplication {



    public static void main(String[] args) {
        SpringApplication.run(WebServicesApplication.class, args);
    }


//    Here we use to overcome the cross Origin Request .. That is to get the call working
//    3000 -> 8080

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                WebMvcConfigurer.super.addCorsMappings(registry);
            registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOrigins("http://localhost:3000");

            }
        };
    }


}
