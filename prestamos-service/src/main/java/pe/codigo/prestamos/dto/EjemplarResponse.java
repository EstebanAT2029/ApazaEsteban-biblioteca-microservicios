package pe.codigo.prestamos.dto;

import lombok.Builder;

@Builder
public record EjemplarResponse(

        String codigoEjemplar,
        String titulo,
        String autor,
        String isbn,
        Integer anioPublicacion,
        Boolean disponible

) {
}
