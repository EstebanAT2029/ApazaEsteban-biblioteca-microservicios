package pe.codigo.notificaciones.dto;

import java.time.LocalDateTime;

public record NotificacionRequest(

        String destino,
        String mensaje,
        String canal,
        String estado,
        LocalDateTime fechaEnvio

) {
}