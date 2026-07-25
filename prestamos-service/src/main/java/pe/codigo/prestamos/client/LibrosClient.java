package pe.codigo.prestamos.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pe.codigo.prestamos.dto.DisponibilidadRequest;
import pe.codigo.prestamos.dto.EjemplarResponse;
import pe.codigo.prestamos.dto.SocioResponse;

@Component
@RequiredArgsConstructor
public class LibrosClient {

    private final RestClient.Builder restClientBuilder;

    private static final String BASE_URL = "http://LIBROS-SERVICE";

    public EjemplarResponse obtenerEjemplar(String codigo) {

        return restClientBuilder.build()
                .get()
                .uri(BASE_URL + "/api/v1/libros/{codigo}", codigo)
                .retrieve()
                .body(EjemplarResponse.class);

    }

    public SocioResponse obtenerSocio(String codigo) {

        return restClientBuilder.build()
                .get()
                .uri(BASE_URL + "/api/v1/socios/{codigo}", codigo)
                .retrieve()
                .body(SocioResponse.class);

    }

    public void actualizarDisponibilidad(String codigo, Boolean disponible) {

        restClientBuilder.build()
                .patch()
                .uri(BASE_URL + "/api/v1/libros/{codigo}/disponibilidad", codigo)
                .body(new DisponibilidadRequest(disponible))
                .retrieve()
                .toBodilessEntity();

    }

}