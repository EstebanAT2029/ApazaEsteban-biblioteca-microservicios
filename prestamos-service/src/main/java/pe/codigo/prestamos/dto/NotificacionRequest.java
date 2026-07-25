package pe.codigo.prestamos.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NotificacionRequest(

        String destino,
        String mensaje,
        String canal,
        String estado,
        LocalDateTime fechaEnvio

) {
}