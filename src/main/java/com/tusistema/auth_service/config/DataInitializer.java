package com.tusistema.auth_service.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tusistema.auth_service.models.Role;
import com.tusistema.auth_service.models.User;
import com.tusistema.auth_service.repository.UserRepository;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("123456")); // contraseña encriptada
                user.setRole(Role.ADMIN);
                user.setFullName("Administrador General");
                user.setDni("75894568");
                user.setCelular("987458963");
                user.setEmail("admin@gmail.com");
                user.setEstado("activo");

                userRepository.save(user);
                System.out.println("✅ Usuario 'admin' creado.");
            } else {
                System.out.println("ℹ️ Usuario 'admin' ya existe.");
            }
        };
    }
}
