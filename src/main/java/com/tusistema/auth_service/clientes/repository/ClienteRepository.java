package com.tusistema.auth_service.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
