package battleForFreedom.modelo.propio;

import battleForFreedom.modelo.tropas.unidades.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class CentroDeMandos {

    private ArrayList<String> equipoJugador;
    private ArrayList<String> mensajesPartida;

    /**
     * Constructor del centro de mandos que inicializa las listas.
     */
    public CentroDeMandos() {
        this.equipoJugador = new ArrayList();
        this.mensajesPartida = new ArrayList();
    }

    /**
     * Método que permite añadir un mensaje a la lista de mensajes del juego
     *
     * @param mensaje mensaje para añadir
     */
    public void actualizarMensajes(String mensaje) {
        this.mensajesPartida.add(mensaje + "\n");
    }

    /**
     * Método que, vacía la antigua lista de equipo, y la rellena con la
     * información más actual, indicando los puntos del jugador en cuestión y
     * todas sus unidades
     *
     * @param jugador jugador actual
     */
    public void actualizarEquipo(Jugador jugador) {
        this.equipoJugador.clear();
        this.equipoJugador.add("Puntos disponibles: " + jugador.getPuntos());
        this.equipoJugador.add("\nUnidades:\n");
        for (Unidad u : jugador.getEjercito()) {
            this.equipoJugador.add(u.toString() + "\n");
        }
    }

    /**
     * Permite obtener la lista de mensajes de la partida de cada jugador para
     * poder mostratla en los menús del juego.
     *
     * @return lista en cuestión
     */
    public ArrayList<String> getMensajes() {
        return this.mensajesPartida;
    }

    /**
     * Permite obtener la lista de unidades y puntos disponibles de cada jugador
     * para poder mostrarla en los menús del juego
     *
     * @param jugador jugador actual
     * @return lista en cuestión
     */
    public ArrayList<String> getEquipoJugador(Jugador jugador) {
        actualizarEquipo(jugador);
        return this.equipoJugador;
    }

}
