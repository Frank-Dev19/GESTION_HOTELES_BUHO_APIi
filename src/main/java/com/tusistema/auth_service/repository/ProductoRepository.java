package com.tusistema.auth_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria_IdCategoria(Long idCategoria);
}
