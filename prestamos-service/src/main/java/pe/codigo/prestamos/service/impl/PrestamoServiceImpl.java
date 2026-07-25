package pe.codigo.prestamos.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.codigo.prestamos.client.LibrosClient;
import pe.codigo.prestamos.client.NotificacionesClient;
import pe.codigo.prestamos.dto.PrestamoRequest;
import pe.codigo.prestamos.dto.PrestamoResponse;
import pe.codigo.prestamos.repository.PrestamoRepository;
import pe.codigo.prestamos.service.PrestamoService;

import java.util.List;

import pe.codigo.prestamos.dto.EjemplarResponse;
import pe.codigo.prestamos.dto.NotificacionRequest;
import pe.codigo.prestamos.dto.SocioResponse;
import pe.codigo.prestamos.entity.Prestamo;
import pe.codigo.prestamos.util.Constantes;

import java.time.LocalDate;

import pe.codigo.prestamos.dto.EjemplarResponse;
import pe.codigo.prestamos.dto.NotificacionRequest;
import pe.codigo.prestamos.dto.SocioResponse;
import pe.codigo.prestamos.entity.Prestamo;
import pe.codigo.prestamos.exception.PrestamoException;
import pe.codigo.prestamos.util.Constantes;
import java.time.LocalDateTime;

import java.time.LocalDate;


import pe.codigo.prestamos.exception.PrestamoNoEncontradoException;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    private final LibrosClient librosClient;

    private final NotificacionesClient notificacionesClient;

    @Override
    public PrestamoResponse registrar(PrestamoRequest request) {

        EjemplarResponse ejemplar = librosClient.obtenerEjemplar(request.codigoEjemplar());

        if (!ejemplar.disponible()) {
            throw new PrestamoException(Constantes.EJEMPLAR_NO_DISPONIBLE);
        }

        SocioResponse socio = librosClient.obtenerSocio(request.codigoSocio());

        if (!socio.activo()) {
            throw new PrestamoException(Constantes.SOCIO_INACTIVO);
        }

        librosClient.actualizarDisponibilidad(
                request.codigoEjemplar(),
                false
        );

        Prestamo prestamo = Prestamo.builder()
                .codigoEjemplar(request.codigoEjemplar())
                .codigoSocio(request.codigoSocio())
                .fechaPrestamo(LocalDate.now())
                .fechaDevolucionEsperada(LocalDate.now().plusDays(7))
                .estado(Constantes.REGISTRADA)
                .build();

        prestamoRepository.save(prestamo);

        notificacionesClient.enviar(
                NotificacionRequest.builder()
                        .destino(socio.email())
                        .mensaje("Su préstamo fue registrado correctamente.")
                        .canal("EMAIL")
                        .estado("ENVIADA")
                        .fechaEnvio(LocalDateTime.now())
                        .build()
        );

        return PrestamoResponse.builder()
                .id(prestamo.getId())
                .codigoEjemplar(prestamo.getCodigoEjemplar())
                .codigoSocio(prestamo.getCodigoSocio())
                .fechaPrestamo(prestamo.getFechaPrestamo())
                .fechaDevolucionEsperada(prestamo.getFechaDevolucionEsperada())
                .estado(prestamo.getEstado())
                .build();
    }

    @Override
    public PrestamoResponse devolver(Long id) {

        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new PrestamoNoEncontradoException(id));

        if (Constantes.DEVUELTO.equals(prestamo.getEstado())) {
            throw new PrestamoException(Constantes.PRESTAMO_DEVUELTO);
        }

        prestamo.setEstado(Constantes.DEVUELTO);
        prestamo.setFechaDevolucionReal(LocalDate.now());

        prestamoRepository.save(prestamo);

        librosClient.actualizarDisponibilidad(
                prestamo.getCodigoEjemplar(),
                true
        );

        SocioResponse socio = librosClient.obtenerSocio(prestamo.getCodigoSocio());

        notificacionesClient.enviar(
                NotificacionRequest.builder()
                        .destino(socio.email())
                        .mensaje("La devolución del libro fue registrada correctamente.")
                        .canal("EMAIL")
                        .estado("ENVIADA")
                        .fechaEnvio(LocalDateTime.now())
                        .build()
        );

        return PrestamoResponse.builder()
                .id(prestamo.getId())
                .codigoEjemplar(prestamo.getCodigoEjemplar())
                .codigoSocio(prestamo.getCodigoSocio())
                .fechaPrestamo(prestamo.getFechaPrestamo())
                .fechaDevolucionEsperada(prestamo.getFechaDevolucionEsperada())
                .estado(prestamo.getEstado())
                .build();
    }

    @Override
    public List<PrestamoResponse> listar() {
        return prestamoRepository.findAll()
                .stream()
                .map(prestamo -> PrestamoResponse.builder()
                        .id(prestamo.getId())
                        .codigoEjemplar(prestamo.getCodigoEjemplar())
                        .codigoSocio(prestamo.getCodigoSocio())
                        .fechaPrestamo(prestamo.getFechaPrestamo())
                        .fechaDevolucionEsperada(prestamo.getFechaDevolucionEsperada())
                        .estado(prestamo.getEstado())
                        .motivoRechazo(prestamo.getMotivoRechazo())
                        .build())
                .toList();
    }

}