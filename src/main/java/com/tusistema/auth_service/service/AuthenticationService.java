package com.tusistema.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.dto.AuthResponse;
import com.tusistema.auth_service.dto.LoginRequest;
import com.tusistema.auth_service.dto.RegisterRequest;
import com.tusistema.auth_service.models.User;
import com.tusistema.auth_service.repository.UserRepository;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var jwt = jwtService.generateToken(user);

        String timeExpires = jwtService.getExpirationDate(jwt);

        return new AuthResponse(jwt, timeExpires, user);
    }

    // public void register(RegisterRequest request) {
    // var user = new User();
    // user.setUsername(request.getUsername());
    // user.setPassword(passwordEncoder.encode(request.getPassword()));
    // user.setFullName(request.getFullName()); // Setear el nombre completo
    // user.setEstado(request.getEstado()); // Setear el estado
    // user.setRole(request.getRole());
    // userRepository.save(user);
    // }

    public void register(RegisterRequest request) {
        User user;

        if (request.getId() != null) {
            user = userRepository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + request.getId()));
        } else {
            user = new User();
            user.setPassword(passwordEncoder.encode(request.getPassword())); // solo codificar si es nuevo
        }

        user.setUsername(request.getUsername());
        user.setDni(request.getDni());
        user.setCelular(request.getCelular());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setEstado(request.getEstado());
        user.setRole(request.getRole());

        // Si es edición y viene una nueva password, la actualiza
        if (request.getId() != null && request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        userRepository.save(user);
    }

}
