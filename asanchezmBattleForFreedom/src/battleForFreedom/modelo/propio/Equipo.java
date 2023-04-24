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
     * @param ejercito Ejercito que contiene a las unidades del jugador.
     */
    public Equipo(Ejercito ejercito) {
        this.ejercito = ejercito;
        this.puntosDisponibles = 0;
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
