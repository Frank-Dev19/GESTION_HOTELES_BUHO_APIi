package com.tusistema.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
