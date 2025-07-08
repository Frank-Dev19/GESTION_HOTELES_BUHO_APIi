package com.tusistema.auth_service.servicios.controller;

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
import com.tusistema.auth_service.servicios.model.CategoriaServicio;
import com.tusistema.auth_service.servicios.service.CategoriaServicioService;

@RestController
@RequestMapping("/categoriaServicio")
public class CategoriaServicioController {

    @Autowired
    private CategoriaServicioService categoriaServicioService;

    @PostMapping("/listarCategoriasServicio")
    public ResponseEntity<List<CategoriaServicio>> listarCategoriasServicio() {
        List<CategoriaServicio> categoriasServicio = categoriaServicioService.obtenerCategoriaServicios();
        return ResponseEntity.ok(categoriasServicio);
    }

    @PostMapping("/guardarCategoriasServicio")
    public ResponseEntity<Boolean> guardarCategoriasReServicio(@RequestBody CategoriaServicio categoriaServicio) {
        try {
            CategoriaServicio categoriaServicioGuardada = categoriaServicioService
                    .guardCategoriaServicio(categoriaServicio);
            return ResponseEntity.ok(true);

        } catch (CategoriaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(false); // Devuelve un código de estado 404 con el mensaje

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(false); // Devuelve un código de estado 500 y false
        }
    }

    @PostMapping("/eliminarCategoriasServicio")
    public ResponseEntity<Void> eliminarCategoriaServicio(
            @RequestBody Map<String, List<Map<String, Integer>>> payload) {

        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long idCategoriaServicio = Long.valueOf(item.get("idCategoriaServicio"));
            categoriaServicioService.eliminarCategoriaServicio(idCategoriaServicio);
        }

        return ResponseEntity.ok().build();

    }

}
