package battleForFreedom.modelo.propio;

import battleForFreedom.modelo.tropas.unidades.Unidad;
import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Ejercito {

    private ArrayList<Unidad> unidades;

    /*
    *  Constructor estandar. Crea una lista de unidades vacía,
    *  que se ampliará al comprar unidades.
     */
    public Ejercito() {
        this.unidades = new ArrayList();
    }

}
