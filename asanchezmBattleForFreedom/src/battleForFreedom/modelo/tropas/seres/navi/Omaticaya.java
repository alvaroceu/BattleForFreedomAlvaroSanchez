package battleForFreedom.modelo.tropas.seres.navi;

import battleForFreedom.modelo.funcionamiento.Raza;
import battleForFreedom.modelo.tropas.seres.Ser;

/**
 *
 * @author Alvaro
 */
public class Omaticaya extends Ser {

    public Omaticaya() {
        super(100, Raza.NAVI, 300, 100);
    }

    /**
     * Representación de Omaticaya
     */
    @Override
    public String toString() {
        return "Omaticaya";
    }
}
