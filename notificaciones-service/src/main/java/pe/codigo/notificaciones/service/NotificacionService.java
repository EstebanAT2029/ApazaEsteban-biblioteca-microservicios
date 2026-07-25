package pe.codigo.notificaciones.service;

import pe.codigo.notificaciones.dto.NotificacionRequest;

public interface NotificacionService {

    void registrar(NotificacionRequest request);

}