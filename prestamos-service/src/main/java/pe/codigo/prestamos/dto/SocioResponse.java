package pe.codigo.prestamos.dto;

import lombok.Builder;

@Builder
public record SocioResponse(

        String codigoSocio,
        String nombre,
        String email,
        String telefono,
        Boolean activo

) {
}