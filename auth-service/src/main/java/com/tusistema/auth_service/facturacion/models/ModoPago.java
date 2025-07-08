package com.tusistema.auth_service.facturacion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modoPago")
    private Long idModoPago;

    @Column(name = "descripcion")
    private String descripcion;

    public Long getIdModoPago() {
        return idModoPago;
    }

    public void setIdModoPago(Long idModoPago) {
        this.idModoPago = idModoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
