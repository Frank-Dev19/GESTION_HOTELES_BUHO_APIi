package com.tusistema.auth_service.habitaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.habitaciones.models.Reserva;
import com.tusistema.auth_service.habitaciones.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public List<Reserva> listarReservasPorEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    public Reserva guardarReseva(Reserva reserva) {
        Reserva reservaN;
        if (reserva.getIdReserva() != null) {
            reservaN = reservaRepository.findById(reserva.getIdReserva())
                    .orElseThrow(
                            () -> new RuntimeException("Reserva no encontrada con el ID" + reserva.getIdReserva()));
        } else {
            reservaN = new Reserva();
        }
        reservaN.setHabitacion(reserva.getHabitacion());
        reservaN.setCliente(reserva.getCliente());
        reservaN.setCheckIn(reserva.getCheckIn());
        reservaN.setCheckOut(reserva.getCheckOut());
        reservaN.setEstado(reserva.getEstado());

        return reservaRepository.save(reservaN);
    }

    public void eliminarReserva(Long idReserva) {
        reservaRepository.deleteById(idReserva);
    }

}
