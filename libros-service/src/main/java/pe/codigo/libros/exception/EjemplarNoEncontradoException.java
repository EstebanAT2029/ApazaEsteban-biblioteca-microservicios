package pe.codigo.libros.exception;

public class EjemplarNoEncontradoException extends RuntimeException {

    public EjemplarNoEncontradoException(String codigo) {
        super("No existe el ejemplar: " + codigo);
    }

}