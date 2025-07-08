package com.tusistema.auth_service.habitaciones.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Habitaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long idHabitacion;

    @Column(name = "numero")
    private int numero;

    // @Column(name = "tipo")
    // private String tipo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_tipoHabitacion", referencedColumnName = "id_tipoHabitacion")
    private TipoHabitacion tipoHabitacion;

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // public String getTipo() {
    // return tipo;
    // }

    // public void setTipo(String tipo) {
    // this.tipo = tipo;
    // }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

}
