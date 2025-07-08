package com.tusistema.auth_service.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.servicios.model.ServicioSolicitud;

public interface SolicitudServicioRepository extends JpaRepository<ServicioSolicitud, Long> {

}
