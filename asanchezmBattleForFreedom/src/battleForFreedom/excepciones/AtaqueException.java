package battleForFreedom.excepciones;

/**
 *
 * @author Alvaro
 */
public class AtaqueException extends Exception {

    private String motivo;

    /*
    *  Constructor, recibe el motivo de la excepcion como parametro
     */
    public AtaqueException(String motivo) {
        this.motivo = motivo;
    }

    /*
    *  Metodo toString, muestra el error en pantalla
     */
    @Override
    public String toString() {
        return "El ataque ha fallado debido a: " + motivo;
    }
}
