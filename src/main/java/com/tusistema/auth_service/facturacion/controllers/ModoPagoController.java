package com.tusistema.auth_service.facturacion.controllers;

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
import com.tusistema.auth_service.facturacion.models.ModoPago;
import com.tusistema.auth_service.facturacion.service.ModoPagoService;

@RestController
@RequestMapping("/modoPago")
public class ModoPagoController {

    @Autowired
    private ModoPagoService modoPagoService;

    @PostMapping("/listarModoPago")
    public ResponseEntity<List<ModoPago>> listarModoPago() {
        List<ModoPago> modoPago = modoPagoService.obtenerModoPagos();
        return ResponseEntity.ok(modoPago);
    }

    @PostMapping("/guardarModoPago")
    public ResponseEntity<Boolean> guardarModoPago(@RequestBody ModoPago modoPago) {
        try {
            modoPagoService.guardarModoPago(modoPago);
            return ResponseEntity.ok(true);

        } catch (CategoriaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PostMapping("/eliminarModoPago")
    public ResponseEntity<Void> eliminarModoPago(@RequestBody Map<String, List<Map<String, Integer>>> payload) {
        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long idModoPago = Long.valueOf(item.get("idModoPago"));
            modoPagoService.eliminarModoPago(idModoPago);
        }

        return ResponseEntity.ok().build();
    }

}
