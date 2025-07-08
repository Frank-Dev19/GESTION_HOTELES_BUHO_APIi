package com.tusistema.auth_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.models.User;
import com.tusistema.auth_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> obtenerTodosLosUsuarios() {
        return userRepository.findAll();
    }

    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }

}
