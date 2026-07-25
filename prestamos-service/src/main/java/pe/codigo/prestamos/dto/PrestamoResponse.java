package pe.codigo.prestamos.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PrestamoResponse(

        Long id,
        String codigoEjemplar,
        String codigoSocio,
        LocalDate fechaPrestamo,
        LocalDate fechaDevolucionEsperada,
        String estado,
        String motivoRechazo

) {
}