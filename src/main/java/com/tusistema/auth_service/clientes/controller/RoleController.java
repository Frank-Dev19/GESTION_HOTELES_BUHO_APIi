package com.tusistema.auth_service.clientes.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusistema.auth_service.clientes.model.Role;
import com.tusistema.auth_service.clientes.service.RoleService;
import com.tusistema.auth_service.exceptions.CategoriaNotFoundException;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/listarRoles")
    public ResponseEntity<List<Role>> listarRole() {
        List<Role> role = roleService.obtenerRoles();
        return ResponseEntity.ok(role);
    }

    @PostMapping("/guardarRoles")
    public ResponseEntity<Boolean> guardarRole(@RequestBody Role role) {
        try {
            roleService.guardarRole(role);
            return ResponseEntity.ok(true);
        } catch (CategoriaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PostMapping("/eliminarRoles")
    public ResponseEntity<Void> eliminarRole(@RequestBody Map<String, List<Map<String, Integer>>> payload) {
        List<Map<String, Integer>> lista = payload.get("listaRequest");
        for (Map<String, Integer> item : lista) {
            Long idRole = Long.valueOf(item.get("idRole"));
            roleService.eliminarRole(idRole);
        }

        return ResponseEntity.ok().build();
    }

}
