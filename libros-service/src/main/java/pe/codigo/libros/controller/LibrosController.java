package pe.codigo.libros.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.codigo.libros.dto.DisponibilidadRequest;
import pe.codigo.libros.dto.EjemplarResponse;
import pe.codigo.libros.dto.SocioResponse;
import pe.codigo.libros.service.LibrosService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LibrosController {

    private final LibrosService librosService;

    @GetMapping("/libros")
    public List<EjemplarResponse> listarLibros() {
        return librosService.listarLibros();
    }

    @GetMapping("/socios")
    public List<SocioResponse> listarSocios() {
        return librosService.listarSocios();
    }

    @GetMapping("/libros/{codigo}")
    public ResponseEntity<EjemplarResponse> obtenerEjemplar(@PathVariable String codigo) {
        return ResponseEntity.ok(librosService.obtenerEjemplar(codigo));
    }

    @GetMapping("/socios/{codigo}")
    public ResponseEntity<SocioResponse> obtenerSocio(@PathVariable String codigo) {
        return ResponseEntity.ok(librosService.obtenerSocio(codigo));
    }

    @PatchMapping("/libros/{codigo}/disponibilidad")
    public ResponseEntity<Void> actualizarDisponibilidad(
            @PathVariable String codigo,
            @RequestBody DisponibilidadRequest request) {

        librosService.actualizarDisponibilidad(
                codigo,
                request.getDisponible());

        return ResponseEntity.noContent().build();
    }

}