package pe.codigo.prestamos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PrestamoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> notFound(PrestamoNoEncontradoException ex){

        return Map.of(
                "timestamp", LocalDateTime.now(),
                "status",404,
                "error","NOT_FOUND",
                "message",ex.getMessage()
        );

    }

    @ExceptionHandler(PrestamoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> badRequest(PrestamoException ex){

        return Map.of(
                "timestamp", LocalDateTime.now(),
                "status",400,
                "error","BAD_REQUEST",
                "message",ex.getMessage()
        );

    }

}
