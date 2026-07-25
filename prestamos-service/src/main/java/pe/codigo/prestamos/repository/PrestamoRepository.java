package pe.codigo.prestamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.codigo.prestamos.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}