package pe.codigo.prestamos.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pe.codigo.prestamos.dto.NotificacionRequest;

@Component
@RequiredArgsConstructor
public class NotificacionesClient {

    private final RestClient.Builder restClientBuilder;

    private static final String BASE_URL = "http://NOTIFICACIONES-SERVICE";

    public void enviar(NotificacionRequest request){

        restClientBuilder.build()
                .post()
                .uri(BASE_URL + "/api/v1/notificaciones")
                .body(request)
                .retrieve()
                .toBodilessEntity();

    }

}