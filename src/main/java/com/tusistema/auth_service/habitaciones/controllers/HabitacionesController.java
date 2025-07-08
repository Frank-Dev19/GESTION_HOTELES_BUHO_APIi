package com.tusistema.auth_service.habitaciones.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusistema.auth_service.habitaciones.models.Habitaciones;
import com.tusistema.auth_service.habitaciones.service.HabitacionService;
import com.tusistema.auth_service.models.Producto;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionesController {

    @Autowired
    private HabitacionService habitacionService;

    @PostMapping("/listarHabitaciones")
    public ResponseEntity<List<Habitaciones>> obtenerTodaasHabitaciones() {
        List<Habitaciones> habitaciones = habitacionService.ObtenerHabitaciones();
        return ResponseEntity.ok(habitaciones);
    }

    @PostMapping("/guardarHabitacion")
    public ResponseEntity<Boolean> guardarHabitacion(@RequestBody Habitaciones habitaciones) {
        try {
            Habitaciones habitacionGruardad = habitacionService.guardarHabitaciones(habitaciones);
            return ResponseEntity.ok(true);

        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }

    }

    @PostMapping("/eliminarHabitacion")
    public ResponseEntity<Void> eliminarHabitacion(@RequestBody Map<String, List<Map<String, Integer>>> payload) {

        System.out.println("Llego el frontend");

        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long idHabitacion = Long.valueOf(item.get("idHabitacion"));
            habitacionService.eliminarHabitacion(idHabitacion);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/listarHabitacionesPorTipo")
    public ResponseEntity<List<Habitaciones>> listarHabitacionesPorTipo(
            @RequestBody Map<String, List<Map<String, Long>>> payload) {
        System.out.println(">> Llegó al backend para listar");

        // Extraemos la lista de la clave "request" del Map
        List<Map<String, Long>> lista = payload.get("request");

        // Verificamos si la lista está vacía o nula
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Retornamos un BadRequest si la lista no contiene elementos
        }

        // Extraemos el idCategoria del primer elemento de la lista
        Long idTipoHabitacion = lista.get(0).get("idTipoHabitacion");

        if (idTipoHabitacion == null) {
            return ResponseEntity.badRequest().build(); // Retornamos BadRequest si no se recibe un idCategoria válido
        }

        // Llamamos al servicio para obtener los productos por categoría
        List<Habitaciones> habitaciones = habitacionService.listarHabitacionesPorTipoHabitacion(idTipoHabitacion);
        return ResponseEntity.ok(habitaciones); // Retornamos la lista de productos
    }

}
