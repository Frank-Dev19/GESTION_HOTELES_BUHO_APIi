package com.tusistema.auth_service.servicios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoriaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoriaServicio")
    private Long idCategoriaServicio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "icono")
    private String icono;

    public Long getIdCategoriaServicio() {
        return idCategoriaServicio;
    }

    public void setIdCategoriaServicio(Long idCategoriaServicio) {
        this.idCategoriaServicio = idCategoriaServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

}
