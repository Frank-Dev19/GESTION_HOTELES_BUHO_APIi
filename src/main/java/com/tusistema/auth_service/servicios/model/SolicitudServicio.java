package com.tusistema.auth_service.servicios.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class SolicitudServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_SolicitudServicio")
    private Long idSolicitudServicio;

    @Column(name = "numeroHabitacion")
    private String numeroHabitacion;

    @OneToMany(mappedBy = "solicitudServicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_ServicioSolicitud", referencedColumnName =
    // "id_ServicioSolicitud")
    private List<ServicioSolicitud> servicioSolicitud;

    @Column(name = "estado")
    private String estado;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "fechaSolicitud")
    private Date fechaSolicitud;

    @Column(name = "fechaCompletado")
    private Date fechaCompletado;

    @Column(name = "empleadoAsignado")
    private String empleadoAsignado;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "total")
    private double total;

}
