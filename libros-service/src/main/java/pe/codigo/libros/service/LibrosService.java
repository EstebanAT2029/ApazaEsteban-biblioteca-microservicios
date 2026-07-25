package pe.codigo.libros.service;

import pe.codigo.libros.dto.EjemplarResponse;
import pe.codigo.libros.dto.SocioResponse;

import java.util.List;

public interface LibrosService {

    List<EjemplarResponse> listarLibros();

    List<SocioResponse> listarSocios();

    EjemplarResponse obtenerEjemplar(String codigo);

    SocioResponse obtenerSocio(String codigo);

    void actualizarDisponibilidad(String codigo, Boolean disponible);
}