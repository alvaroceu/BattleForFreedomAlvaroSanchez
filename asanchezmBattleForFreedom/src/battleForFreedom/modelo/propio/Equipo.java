package battleForFreedom.modelo.propio;

/**
 *
 * @author Alvaro
 */
public class Equipo {

    private Ejercito ejercito;
    private int puntosDisponibles;
    //Falta implementar: atributo "centroDeMando"

    /**
     * Constructor de objetos de la clase Ejercito.
     *
     * @param puntosDisponibles Puntos del equipo
     */
    public Equipo(int puntosDisponibles) {
        this.ejercito = new Ejercito();
        this.puntosDisponibles = puntosDisponibles;
    }

    /**
     * Permite obtener el Ejercito de un Jugador
     *
     * @return Ejercito
     */
    public Ejercito getEjercito() {
        return ejercito;
    }

    /**
     * Permite obtener los puntos disponibles de un Jugador
     *
     * @return Puntos disponibles para usar
     */
    public int getPuntosDisponibles() {
        return puntosDisponibles;
    }

    /**
     * Permite modificar los puntos disponibles de un jugador
     *
     * @param puntosDisponibles Nuevo valor de los puntos disponibles
     */
    public void setPuntosDisponibles(int puntosDisponibles) {
        this.puntosDisponibles = puntosDisponibles;
    }

    /**
     * Representación de la clase equipo.
     *
     * @return Cadena indicando los puntos disponibles y las unidades poseídas.
     */
    @Override
    public String toString() {
        return "Puntos Disponibles: " + this.puntosDisponibles
                + "\n" + this.ejercito;
    }
}
