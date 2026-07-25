package pe.codigo.libros.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.codigo.libros.dto.EjemplarResponse;
import pe.codigo.libros.dto.SocioResponse;
import pe.codigo.libros.repository.EjemplarRepository;
import pe.codigo.libros.repository.SocioRepository;
import pe.codigo.libros.service.LibrosService;
import pe.codigo.libros.entity.Ejemplar;
import pe.codigo.libros.entity.Socio;
import pe.codigo.libros.exception.EjemplarNoEncontradoException;
import pe.codigo.libros.exception.SocioNoEncontradoException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrosServiceImpl implements LibrosService {

    private final EjemplarRepository ejemplarRepository;
    private final SocioRepository socioRepository;


    @Override
    public List<EjemplarResponse> listarLibros() {

        return ejemplarRepository.findAll()
                .stream()
                .map(libro -> EjemplarResponse.builder()
                        .codigoEjemplar(libro.getCodigoEjemplar())
                        .titulo(libro.getTitulo())
                        .autor(libro.getAutor())
                        .isbn(libro.getIsbn())
                        .anioPublicacion(libro.getAnioPublicacion())
                        .disponible(libro.getDisponible())
                        .build())
                .toList();

    }

    @Override
    public List<SocioResponse> listarSocios() {

        return socioRepository.findAll()
                .stream()
                .map(socio -> SocioResponse.builder()
                        .codigoSocio(socio.getCodigoSocio())
                        .nombre(socio.getNombre())
                        .email(socio.getEmail())
                        .telefono(socio.getTelefono())
                        .activo(socio.getActivo())
                        .build())
                .toList();

    }

    @Override
    public EjemplarResponse obtenerEjemplar(String codigo) {

        Ejemplar libro = ejemplarRepository.findById(codigo)
                .orElseThrow(() -> new EjemplarNoEncontradoException(codigo));

        return EjemplarResponse.builder()
                .codigoEjemplar(libro.getCodigoEjemplar())
                .titulo(libro.getTitulo())
                .autor(libro.getAutor())
                .isbn(libro.getIsbn())
                .anioPublicacion(libro.getAnioPublicacion())
                .disponible(libro.getDisponible())
                .build();

    }

    @Override
    public SocioResponse obtenerSocio(String codigo) {

        Socio socio = socioRepository.findById(codigo)
                .orElseThrow(() -> new SocioNoEncontradoException(codigo));

        return SocioResponse.builder()
                .codigoSocio(socio.getCodigoSocio())
                .nombre(socio.getNombre())
                .email(socio.getEmail())
                .telefono(socio.getTelefono())
                .activo(socio.getActivo())
                .build();

    }

    @Override
    public void actualizarDisponibilidad(String codigo, Boolean disponible) {

        Ejemplar libro = ejemplarRepository.findById(codigo)
                .orElseThrow(() -> new EjemplarNoEncontradoException(codigo));

        libro.setDisponible(disponible);

        ejemplarRepository.save(libro);

    }

}
