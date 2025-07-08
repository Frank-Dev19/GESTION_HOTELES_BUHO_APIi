package com.tusistema.auth_service.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusistema.auth_service.exceptions.CategoriaNotFoundException;
import com.tusistema.auth_service.models.Categoria;
import com.tusistema.auth_service.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/listarCategorias")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaService.obtenerCategorias();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping("/guardarCategorias")
    public ResponseEntity<Boolean> guardarCategoria(@RequestBody Categoria categoria) {
        try {
            // Intentamos guardar la categoría
            Categoria categoriaGuardada = categoriaService.guardarCategoria(categoria);
            return ResponseEntity.ok(true); // Devuelve true si se guarda correctamente
        } catch (CategoriaNotFoundException e) {
            // Excepción específica de categoría no encontrada
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(false); // Devuelve un código de estado 404 con el mensaje
        } catch (Exception e) {
            // Captura errores generales y los envía como un error 500 (error interno)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(false); // Devuelve un código de estado 500 y false
        }
    }

    // public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria
    // categoria) {
    // Categoria categoriaGuardada = categoriaService.guardarCategoria(categoria);
    // return ResponseEntity.ok(categoriaGuardada);
    // }

    @PostMapping("/eliminarCategorias")
    public ResponseEntity<Void> eliminarCategoria(@RequestBody Map<String, List<Map<String, Integer>>> payload) {
        System.out.println(">> Llegó al backend para eliminar categ");

        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long idCategoria = Long.valueOf(item.get("idCategoria"));
            categoriaService.eliminarCategoria(idCategoria);
        }

        return ResponseEntity.ok().build();

    }
}
