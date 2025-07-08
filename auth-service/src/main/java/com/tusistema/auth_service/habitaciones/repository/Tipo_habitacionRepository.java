package com.tusistema.auth_service.habitaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tusistema.auth_service.habitaciones.models.TipoHabitacion;

public interface Tipo_habitacionRepository extends JpaRepository<TipoHabitacion, Long> {

}
