package pe.codigo.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.codigo.libros.entity.Socio;

public interface SocioRepository extends JpaRepository<Socio, String> {
}