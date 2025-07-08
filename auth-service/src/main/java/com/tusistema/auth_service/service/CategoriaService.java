package com.tusistema.auth_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.models.Categoria;
import com.tusistema.auth_service.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    // Guardar categoría
    public Categoria guardarCategoria(Categoria categoria) {
        Categoria category;

        if (categoria.getIdCategoria() != null) {
            category = categoriaRepository.findById(categoria.getIdCategoria())
                    .orElseThrow(
                            () -> new RuntimeException(
                                    "Categoria no encontrada con el ID: " + categoria.getIdCategoria()));

        } else {
            category = new Categoria();
        }
        category.setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(categoria);
    }

    // Eliminar categoría
    public void eliminarCategoria(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}
