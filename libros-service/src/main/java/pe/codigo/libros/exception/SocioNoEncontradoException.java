package pe.codigo.libros.exception;

public class SocioNoEncontradoException extends RuntimeException {

    public SocioNoEncontradoException(String codigo) {
        super("No existe el socio: " + codigo);
    }

}