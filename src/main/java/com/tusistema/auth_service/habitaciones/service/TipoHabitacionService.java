package com.tusistema.auth_service.habitaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.habitaciones.models.TipoHabitacion;
import com.tusistema.auth_service.habitaciones.repository.Tipo_habitacionRepository;

@Service
public class TipoHabitacionService {

    @Autowired
    private Tipo_habitacionRepository tipo_habitacionRepository;

    public List<TipoHabitacion> obtenerTipoHabitacion() {
        return tipo_habitacionRepository.findAll();
    }

    public TipoHabitacion guardarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        TipoHabitacion tipoHabitacionN;

        if (tipoHabitacion.getIdTipoHabitacion() != null) {
            tipoHabitacionN = tipo_habitacionRepository.findById(tipoHabitacion.getIdTipoHabitacion()).orElseThrow(
                    () -> new RuntimeException(
                            "Tipo de habitacion no encontrada con el Id" + tipoHabitacion.getIdTipoHabitacion()));

        } else {
            tipoHabitacionN = new TipoHabitacion();
        }
        tipoHabitacionN.setDescripcion(tipoHabitacion.getDescripcion());
        tipoHabitacionN.setPrecio(tipoHabitacion.getPrecio());
        tipoHabitacionN.setCapacidad(tipoHabitacion.getCapacidad());
        tipoHabitacionN.setImagenUrl(tipoHabitacion.getImagenUrl());

        return tipo_habitacionRepository.save(tipoHabitacionN);

    }

    public void eliminarTipoHabitacion(long idTipoHabitacion) {
        tipo_habitacionRepository.deleteById(idTipoHabitacion);
    }

}
