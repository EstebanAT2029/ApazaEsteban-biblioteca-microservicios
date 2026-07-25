package pe.codigo.prestamos.exception;

public class PrestamoNoEncontradoException extends RuntimeException {

    public PrestamoNoEncontradoException(Long id) {
        super("No existe el préstamo: " + id);
    }

}