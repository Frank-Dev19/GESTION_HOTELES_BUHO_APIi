package com.tusistema.auth_service.habitaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.habitaciones.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEstado(String estado);

}
