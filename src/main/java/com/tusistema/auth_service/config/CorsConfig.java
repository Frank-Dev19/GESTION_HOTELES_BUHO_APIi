package com.tusistema.auth_service.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // // Permitir solicitudes desde el puerto 4200
    // registry.addMapping("/**")
    // .allowedOrigins("http://localhost:4200") // Aquí pones la URL de tu frontend
    // .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
    // .allowedHeaders("*")
    // .allowCredentials(true); // Si usas credenciales como cookies o headers de
    // autorización
    // }

}
