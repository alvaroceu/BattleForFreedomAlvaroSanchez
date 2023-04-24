package battleForFreedom.modelo.propio;

import battleForFreedom.modelo.tropas.unidades.Unidad;
import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Ejercito {

    private ArrayList<Unidad> unidades;

    /**
     * Constructor de objetos de la clase Ejercito.Crea una lista vacía de
     * unidades.Es necesario comprar unidades para añadirlas a la lista.
     */
    public Ejercito() {
        this.unidades = new ArrayList();
    }

    /**
     * Permite obtener la lista de Unidades del ejército de cada equipo.
     *
     * @return Lista de unidades
     */
    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }

    /**
     * Representacion de la clase Ejercito.
     *
     * @return Cadena que indica las unidades poseídas.
     */
    @Override
    public String toString() {
        return "Ejercito:\n " + this.unidades;
    }

}
