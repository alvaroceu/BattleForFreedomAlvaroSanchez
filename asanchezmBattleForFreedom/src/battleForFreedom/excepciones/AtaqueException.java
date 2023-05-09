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
     * Permite obtener el motivo de la excepción, con el objetivo de saber cómo
     * debe tratarse
     *
     * @return motivo de la excepción.
     */
    public String getMotivo() {
        return this.motivo;
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
