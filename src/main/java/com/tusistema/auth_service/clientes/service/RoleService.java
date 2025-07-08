package com.tusistema.auth_service.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.clientes.model.Role;
import com.tusistema.auth_service.clientes.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> obtenerRoles() {
        return roleRepository.findAll();
    }

    public Role guardarRole(Role role) {

        Role roleN;
        if (role.getIdRole() != null) {
            roleN = roleRepository.findById(role.getIdRole()).orElseThrow(
                    () -> new RuntimeException("Role no encontrado con el id " + role.getDescripcion()));
        } else {
            roleN = new Role();
        }

        roleN.setDescripcion(role.getDescripcion());
        return roleRepository.save(roleN);

    }

    public void eliminarRole(Long idRole) {
        roleRepository.deleteById(idRole);
    }
}
