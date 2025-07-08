package com.tusistema.auth_service.servicios.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusistema.auth_service.servicios.model.Servicio;
import com.tusistema.auth_service.servicios.service.ServicioService;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping("/listarServicios")
    public ResponseEntity<List<Servicio>> obtenerTodosLosServicios() {
        List<Servicio> servicios = servicioService.obtenerServicios();
        return ResponseEntity.ok(servicios);
    }

    @PostMapping("/guardarServicios")
    public ResponseEntity<Boolean> guardarServicio(@RequestBody Servicio servicio) {
        try {
            Servicio servicioguardado = servicioService.guardaServicio(servicio);
            return ResponseEntity.ok(true); // Si el servicio se guardó con éxito
        } catch (Exception e) {
            return ResponseEntity.ok(false); // Si ocurrió algún error al guardar el servicio
        }
    }

    @PostMapping("/eliminarServicios")
    public ResponseEntity<Void> eliminarServicio(@RequestBody Map<String, List<Map<String, Integer>>> payload) {
        System.out.println(">> Llegó al backend para eliminar servicio");

        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long idServicio = Long.valueOf(item.get("idServicio"));
            servicioService.eliminarServicio(idServicio);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/listarServiciosPorCategoria")
    public ResponseEntity<List<Servicio>> listarServiciosPorCategoria(
            @RequestBody Map<String, List<Map<String, Long>>> payload) {
        System.out.println(">> Llegó al backend para listar servicios por categoría");

        // Extraemos la lista de la clave "request" del Map
        List<Map<String, Long>> lista = payload.get("request");

        // Verificamos si la lista está vacía o nula
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Retornamos un BadRequest si la lista no contiene elementos
        }

        // Extraemos el idCategoriaServicio del primer elemento de la lista
        Long idCategoriaServicio = lista.get(0).get("idCategoriaServicio");

        if (idCategoriaServicio == null) {
            return ResponseEntity.badRequest().build(); // Retornamos BadRequest si no se recibe un idCategoriaServicio
                                                        // válido
        }

        // Llamamos al servicio para obtener los servicios por categoría
        List<Servicio> servicios = servicioService.listarServiciosPorCategoria(idCategoriaServicio);
        return ResponseEntity.ok(servicios); // Retornamos la lista de servicios
    }

}
