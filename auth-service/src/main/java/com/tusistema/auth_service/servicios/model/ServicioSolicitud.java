package com.tusistema.auth_service.servicios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServicioSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ServicioSolicitud")
    private Long idServicioSolicitud;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_SolicitudServicio", referencedColumnName = "id_SolicitudServicio")
    private SolicitudServicio solicitudServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Servicio servicio;

    @Column(name = "cantidad")
    private int cantidad;
}
