package pe.codigo.libros.dto;

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