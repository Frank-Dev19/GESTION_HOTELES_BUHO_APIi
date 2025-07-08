package com.tusistema.auth_service.habitaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.habitaciones.models.Habitaciones;

import java.util.List;

public interface HabitacionesRepository extends JpaRepository<Habitaciones, Long> {
    List<Habitaciones> findByTipoHabitacion_IdTipoHabitacion(Long idTipoHabitacion);
}
