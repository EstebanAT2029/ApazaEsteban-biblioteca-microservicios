package pe.codigo.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.codigo.libros.entity.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, String> {
}
