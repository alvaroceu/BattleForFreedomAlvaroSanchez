package battleForFreedom.modelo.propio;

/**
 *
 * @author Alvaro
 */
public class Equipo {

    private Ejercito ejercito;
    private int puntosDisponibles;
    //Falta implementar: atributo "centroDeMando"

    /*
    *  Constructor que siempre recibe un equipo como parametro.
    *  Inicializa los puntos a 0, y se establecen posteriormente
    *  en funcion del escenario escogido.
     */
    public Equipo(Ejercito ejercito) {
        this.ejercito = ejercito;
        this.puntosDisponibles = 0;
    }

    /*
    *  Metodo toString para representar la clase Jugador
     */
    @Override
    public String toString() {
        return "Puntos Disponibles: " + this.puntosDisponibles
                + "\n" + this.ejercito;
    }
}
