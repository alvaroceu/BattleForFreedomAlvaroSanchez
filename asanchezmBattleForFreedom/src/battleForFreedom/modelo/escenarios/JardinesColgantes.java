package battleForFreedom.modelo.escenarios;

/**
 *
 * @author Alvaro
 */
public class JardinesColgantes extends Escenario {

    /**
     * Constructor de el Escenario: Jardines Colgantes.Establece los puntos
     * iniciales a 20000, y tiene una dimensiond e 200x200.
     */
    public JardinesColgantes() {
        super(20000, 199);
    }

    /**
     * Representacion del Escenario
     *
     * @return Nombre del escenario: Jardines Colgantes
     */
    @Override
    public String toString() {
        return "Jardines Colgantes";
    }
}
