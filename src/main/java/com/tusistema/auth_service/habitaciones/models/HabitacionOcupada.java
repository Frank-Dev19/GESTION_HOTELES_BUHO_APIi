package com.tusistema.auth_service.habitaciones.models;

import java.util.Date;

import com.tusistema.auth_service.clientes.model.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HabitacionOcupada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_HabitacionOcupada")
    private Long idHabitacionOcupada;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    @Column(name = "checkIn")
    private Date checkIn;

    @Column(name = "checkOn")
    private Date checkOn;

    @Column(name = "TipoHabitacion")
    private String TipoHabitacion;
}
