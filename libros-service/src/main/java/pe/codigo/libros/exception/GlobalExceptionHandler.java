package pe.codigo.libros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EjemplarNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> ejemplarNoEncontrado(EjemplarNoEncontradoException ex){

        return Map.of(
                "timestamp", LocalDateTime.now(),
                "status",404,
                "error","NOT_FOUND",
                "message",ex.getMessage()
        );

    }

    @ExceptionHandler(SocioNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> socioNoEncontrado(SocioNoEncontradoException ex){

        return Map.of(
                "timestamp", LocalDateTime.now(),
                "status",404,
                "error","NOT_FOUND",
                "message",ex.getMessage()
        );

    }

}