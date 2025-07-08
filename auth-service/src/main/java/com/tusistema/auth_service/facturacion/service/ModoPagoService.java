package com.tusistema.auth_service.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.facturacion.models.ModoPago;
import com.tusistema.auth_service.facturacion.repository.ModoPagoRepository;

@Service
public class ModoPagoService {

    @Autowired
    private ModoPagoRepository modoPagoRepository;

    public List<ModoPago> obtenerModoPagos() {
        return modoPagoRepository.findAll();
    }

    public ModoPago guardarModoPago(ModoPago modoPago) {
        ModoPago modoPago2;

        if (modoPago.getIdModoPago() != null) {
            modoPago2 = modoPagoRepository.findById(modoPago.getIdModoPago()).orElseThrow(
                    () -> new RuntimeException(
                            "Modo de pago no encontrado con el ID " + modoPago.getIdModoPago()));
        } else {
            modoPago2 = new ModoPago();
        }

        modoPago2.setDescripcion(modoPago.getDescripcion());
        return modoPagoRepository.save(modoPago2);
    }

    public void eliminarModoPago(Long idModoPago) {
        modoPagoRepository.deleteById(idModoPago);
    }
}
