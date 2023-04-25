package battleForFreedom.modelo.tropas.seres.navi;

import battleForFreedom.modelo.funcionamiento.Raza;
import battleForFreedom.modelo.tropas.seres.Ser;

/**
 *
 * @author Alvaro
 */
public class Tipani extends Ser {

    public Tipani() {
        super(50, Raza.NAVI, 300, 250);
    }

    /**
     * Representación de Tipani
     */
    @Override
    public String toString() {
        return "Tipani";
    }
}
