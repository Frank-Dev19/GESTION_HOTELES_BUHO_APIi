package com.tusistema.auth_service.dto;

import com.tusistema.auth_service.models.Role;

public class RegisterRequest {
    private Long id;
    private String username;
    private String password;
    private String dni;
    private String celular;
    private String email;
    private String fullName; // Nuevo campo para el nombre completo
    private String estado; // Nuevo campo para el estado (activo/inactivo)
    private Role role;

    public RegisterRequest() {
    }

    public RegisterRequest(Long is, String username, String password, String dni, String celular, String email,
            String fullName, String estado, Role role) {
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.celular = celular;
        this.email = email;
        this.fullName = fullName;
        this.estado = estado;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
