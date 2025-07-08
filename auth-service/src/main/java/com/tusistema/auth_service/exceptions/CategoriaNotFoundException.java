package com.tusistema.auth_service.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(String message) {
        super(message);
    }
}
