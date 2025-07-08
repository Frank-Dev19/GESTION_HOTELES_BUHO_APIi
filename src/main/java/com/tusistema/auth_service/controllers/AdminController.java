package com.tusistema.auth_service.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "✅ Acceso permitido solo para ADMIN";
    }

}
