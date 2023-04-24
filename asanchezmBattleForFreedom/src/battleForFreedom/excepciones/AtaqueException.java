package battleForFreedom.excepciones;

/**
 *
 * @author Alvaro
 */
public class AtaqueException extends Exception {

    private String motivo;

    /**
     * Constructor de excepciones AtaqueException.
     *
     * @param motivo Causa de la excepcion.
    *
     */
    public AtaqueException(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Representacion de AtaqueException.
    *
     */
    @Override
    public String toString() {
        return "El ataque ha fallado debido a: " + motivo;
    }
}
