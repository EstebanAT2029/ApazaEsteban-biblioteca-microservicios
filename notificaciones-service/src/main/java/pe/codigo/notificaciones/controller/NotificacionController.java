package pe.codigo.notificaciones.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.codigo.notificaciones.dto.NotificacionRequest;
import pe.codigo.notificaciones.service.NotificacionService;

@RestController
@RequestMapping("/api/v1/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registrar(@RequestBody NotificacionRequest request) {

        notificacionService.registrar(request);

    }

}