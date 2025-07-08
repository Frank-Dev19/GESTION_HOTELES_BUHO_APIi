package com.tusistema.auth_service.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusistema.auth_service.models.User;
import com.tusistema.auth_service.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/listarUsuarios")
    public ResponseEntity<List<User>> listarUsuarios() {
        System.out.println(">> Llegó al backend para listar usuarios");
        List<User> usuarios = userService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/eliminarUsuarios")
    public ResponseEntity<Void> eliminarUsuarios(@RequestBody Map<String, List<Map<String, Integer>>> payload) {
        System.out.println(">> Llegó al backend para eliminar usuarios");

        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long id = Long.valueOf(item.get("id"));
            userService.eliminarUsuario(id);
        }

        return ResponseEntity.ok().build();

    }

}
