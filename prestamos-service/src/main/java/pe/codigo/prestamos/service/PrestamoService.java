package pe.codigo.prestamos.service;

import pe.codigo.prestamos.dto.PrestamoRequest;
import pe.codigo.prestamos.dto.PrestamoResponse;

import java.util.List;

public interface PrestamoService {

    PrestamoResponse registrar(PrestamoRequest request);

    PrestamoResponse devolver(Long id);

    List<PrestamoResponse> listar();

}