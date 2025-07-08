package com.tusistema.auth_service.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.clientes.model.Cliente;
import com.tusistema.auth_service.clientes.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente guardarCliente(Cliente cliente) {

        Cliente clienteN;

        if (cliente.getIdCliente() != null) {
            clienteN = clienteRepository.findById(cliente.getIdCliente())
                    .orElseThrow(
                            () -> new RuntimeException("Cliente no encontrado con ID: " + cliente.getIdCliente()));
        } else {
            clienteN = new Cliente();
        }

        clienteN.setNombreCompleto(cliente.getNombreCompleto());
        clienteN.setDni(cliente.getDni());
        clienteN.setFechaRegistro(cliente.getFechaRegistro());

        return clienteRepository.save(clienteN);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
