package pe.codigo.notificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.codigo.notificaciones.entity.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}