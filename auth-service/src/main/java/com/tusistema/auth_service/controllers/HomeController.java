package com.tusistema.auth_service.controllers;

//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = "http://localhost:4200/")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Bienvenido al Home";
    }
}
