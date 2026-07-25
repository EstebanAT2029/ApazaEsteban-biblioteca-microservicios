package pe.codigo.notificaciones.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.codigo.notificaciones.dto.NotificacionRequest;
import pe.codigo.notificaciones.entity.Notificacion;
import pe.codigo.notificaciones.repository.NotificacionRepository;
import pe.codigo.notificaciones.service.NotificacionService;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionRepository notificacionRepository;

    @Override
    public void registrar(NotificacionRequest request) {

        Notificacion notificacion = Notificacion.builder()
                .destino(request.destino())
                .mensaje(request.mensaje())
                .canal(request.canal())
                .estado(request.estado())
                .fechaEnvio(request.fechaEnvio())
                .build();

        notificacionRepository.save(notificacion);

    }

}