package com.tusistema.auth_service.habitaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.habitaciones.models.Habitaciones;
import com.tusistema.auth_service.habitaciones.repository.HabitacionesRepository;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionesRepository habitacionesRepository;

    public List<Habitaciones> ObtenerHabitaciones() {
        return habitacionesRepository.findAll();
    }

    public Habitaciones guardarHabitaciones(Habitaciones habitaciones) {
        Habitaciones habitacionesN;

        if (habitaciones.getIdHabitacion() != null) {
            habitacionesN = habitacionesRepository.findById(habitaciones.getIdHabitacion())
                    .orElseThrow(
                            () -> new RuntimeException(
                                    "Habitacion no encontrada con ID" + habitaciones.getIdHabitacion()));
        } else {
            habitacionesN = new Habitaciones();
        }

        habitacionesN.setNumero(habitaciones.getNumero());
        habitacionesN.setEstado(habitaciones.getEstado());
        habitacionesN.setTipoHabitacion(habitaciones.getTipoHabitacion());

        return habitacionesRepository.save(habitacionesN);
    }

    public void eliminarHabitacion(Long idHabitacion) {
        habitacionesRepository.deleteById(idHabitacion);
    }

    public List<Habitaciones> listarHabitacionesPorTipoHabitacion(Long idTipoHabitacion) {
        return habitacionesRepository.findByTipoHabitacion_IdTipoHabitacion(idTipoHabitacion);
    }

}
