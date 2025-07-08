package com.tusistema.auth_service.dto;

import com.tusistema.auth_service.models.User;

public class AuthResponse {
    private String token;
    private String timeExpires;
    private User usuario;

    public AuthResponse(String token, String timeExpires, User usuario) {
        this.token = token;
        this.timeExpires = timeExpires;
        this.usuario = usuario;
    }

    public AuthResponse() {
    }

    public String getTimeExpires() {
        return timeExpires;
    }

    public void setTimeExpires(String timeExpires) {
        this.timeExpires = timeExpires;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
