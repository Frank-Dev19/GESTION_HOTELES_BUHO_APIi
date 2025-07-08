package com.tusistema.auth_service.servicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.servicios.model.Servicio;
import com.tusistema.auth_service.servicios.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    public Servicio guardaServicio(Servicio servicio) {
        Servicio servicion;
        if (servicio.getIdServicio() != null) {
            servicion = servicioRepository.findById(servicio.getIdServicio())
                    .orElseThrow(
                            () -> new RuntimeException("Servicio no encontrado con ID: " + servicio.getIdServicio()));
        } else {
            servicion = new Servicio();
        }

        servicion.setCategoriaServicio(servicio.getCategoriaServicio());
        servicion.setNombre(servicio.getNombre());
        servicion.setDescripcion(servicio.getDescripcion());
        servicion.setPrecio(servicio.getPrecio());
        servicion.setImagenServicio(servicio.getImagenServicio());
        servicion.setActivo(servicio.isActivo());

        return servicioRepository.save(servicion);
    }

    public void eliminarServicio(Long idServicio) {
        servicioRepository.deleteById(idServicio);
    }

    public List<Servicio> listarServiciosPorCategoria(Long idServicio) {
        return servicioRepository.findByCategoriaServicio_IdCategoriaServicio(idServicio);
    }

}
