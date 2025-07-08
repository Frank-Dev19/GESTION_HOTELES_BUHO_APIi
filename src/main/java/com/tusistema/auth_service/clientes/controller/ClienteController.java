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

import com.tusistema.auth_service.clientes.model.Cliente;
import com.tusistema.auth_service.clientes.service.ClienteService;
import com.tusistema.auth_service.exceptions.CategoriaNotFoundException;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> listarCliente() {
        List<Cliente> cliente = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/guardarClientes")
    public ResponseEntity<Boolean> guardarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.guardarCliente(cliente);
            return ResponseEntity.ok(true);
        } catch (CategoriaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PostMapping("/eliminarClientes")
    public ResponseEntity<Void> eliminarCliente(@RequestBody Map<String, List<Map<String, Integer>>> payload) {
        List<Map<String, Integer>> lista = payload.get("listaRequest");
        for (Map<String, Integer> item : lista) {
            Long idCliente = Long.valueOf(item.get("idCliente"));
            clienteService.eliminarCliente(idCliente);
        }

        return ResponseEntity.ok().build();
    }

}
