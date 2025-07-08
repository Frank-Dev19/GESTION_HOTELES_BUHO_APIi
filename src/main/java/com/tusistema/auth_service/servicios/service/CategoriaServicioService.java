package com.tusistema.auth_service.servicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.servicios.model.CategoriaServicio;
import com.tusistema.auth_service.servicios.repository.CategoriaServicioRepository;

@Service
public class CategoriaServicioService {

    @Autowired
    private CategoriaServicioRepository categoriaServicioRepository;

    public List<CategoriaServicio> obtenerCategoriaServicios() {
        return categoriaServicioRepository.findAll();
    }

    public CategoriaServicio guardCategoriaServicio(CategoriaServicio categoriaServicio) {
        CategoriaServicio categoriaServicion;

        if (categoriaServicio.getIdCategoriaServicio() != null) {
            categoriaServicion = categoriaServicioRepository.findById(categoriaServicio.getIdCategoriaServicio())
                    .orElseThrow(
                            () -> new RuntimeException("Categoria de Servicio no encontrada con el ID: "
                                    + categoriaServicio.getIdCategoriaServicio()));
        } else {

            categoriaServicion = new CategoriaServicio();

        }
        categoriaServicion.setNombre(categoriaServicio.getNombre());
        categoriaServicion.setIcono(categoriaServicio.getIcono());

        return categoriaServicioRepository.save(categoriaServicion);
    }

    public void eliminarCategoriaServicio(Long idCategoriaServicio) {
        categoriaServicioRepository.deleteById(idCategoriaServicio);
    }

}
