package battleForFreedom.modelo.escenarios;

/**
 *
 * @author Alvaro
 */
public class ArbolMadre extends Escenario {

    /**
     * Constructor de el Escenario: Arbol Madre.Establece los puntos iniciales a
     * 45000, y tiene una dimensiond e 300x300.
     */
    public ArbolMadre() {
        super(45000, 299);
    }

    /**
     * Representacion del Escenario
     *
     * @return Nombre del escenario: Arbol Madre
     */
    @Override
    public String toString() {
        return "Arbol Madre";
    }
}
