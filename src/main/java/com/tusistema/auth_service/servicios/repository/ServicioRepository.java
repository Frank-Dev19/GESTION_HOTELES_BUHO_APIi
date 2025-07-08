package com.tusistema.auth_service.servicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.servicios.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    List<Servicio> findByCategoriaServicio_IdCategoriaServicio(Long idCategoriaServicio);
}
