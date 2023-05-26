package battleForFreedom.modelo.escenarios;

/**
 *
 * @author Alvaro
 */
public class ArbolDeLasAlmas extends Escenario {

    /**
     * Constructor de el Escenario: Arbol de las Almas.Establece los puntos
     * iniciales a 5000, y tiene una dimensiond e 100x100.
     */
    public ArbolDeLasAlmas() {
        super(5000, 100);
    }

    /**
     * Representacion del Escenario
     *
     * @return Nombre del escenario: Arbol de las Almas
     */
    @Override
    public String toString() {
        return "Arbol de las Almas";
    }
}
