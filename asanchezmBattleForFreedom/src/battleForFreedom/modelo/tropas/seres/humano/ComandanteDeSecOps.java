package battleForFreedom.modelo.tropas.seres.humano;

import battleForFreedom.modelo.funcionamiento.Raza;
import battleForFreedom.modelo.tropas.seres.Ser;

/**
 *
 * @author Alvaro
 */
public class ComandanteDeSecOps extends Ser {

    public ComandanteDeSecOps() {
        super(100, Raza.HUMANO, 150, 400);
    }

    /**
     * Representación de Comandante de Sec Ops
     */
    @Override
    public String toString() {
        return "Comandante de Sec Ops";
    }
}
