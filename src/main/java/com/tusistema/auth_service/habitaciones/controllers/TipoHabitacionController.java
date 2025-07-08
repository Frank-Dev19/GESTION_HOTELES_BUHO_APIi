package com.tusistema.auth_service.habitaciones.controllers;

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
import com.tusistema.auth_service.habitaciones.models.TipoHabitacion;
import com.tusistema.auth_service.habitaciones.service.TipoHabitacionService;

@RestController
@RequestMapping("/tipoHabitacion")
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionService tipoHabitacionService;

    @PostMapping("/listarTipoHabitacion")
    public ResponseEntity<List<TipoHabitacion>> listartipoHabitaciones() {
        List<TipoHabitacion> tipoHabitacion = tipoHabitacionService.obtenerTipoHabitacion();
        return ResponseEntity.ok(tipoHabitacion);
    }

    @PostMapping("/guardarTipoHabitacion")
    public ResponseEntity<Boolean> guardarTipoHabitacion(@RequestBody TipoHabitacion tipoHabitacion) {
        try {
            TipoHabitacion tipoHabitacionGuardada = tipoHabitacionService.guardarTipoHabitacion(tipoHabitacion);
            return ResponseEntity.ok(true);

        } catch (CategoriaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PostMapping("/eliminarTipoHabitacion")
    public ResponseEntity<Void> eliminarTipoHabitacion(@RequestBody Map<String, List<Map<String, Integer>>> payload) {

        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long idTipoHabitacion = Long.valueOf(item.get("idTipoHabitacion"));
            tipoHabitacionService.eliminarTipoHabitacion(idTipoHabitacion);
        }

        return ResponseEntity.ok().build();
    }

}
