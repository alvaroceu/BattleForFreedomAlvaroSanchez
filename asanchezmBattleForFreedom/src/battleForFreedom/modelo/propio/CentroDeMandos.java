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
    private Jugador jugador;

    public CentroDeMandos(Jugador jugador) {
        this.equipoJugador = new ArrayList();
        this.mensajesPartida = new ArrayList();
    }

    public void actualizarMensajes(String mensaje) {
        this.mensajesPartida.add(mensaje);
    }

    public void actualizarEquipo() {
        this.equipoJugador.clear();
        this.equipoJugador.add("Puntos disponibles: " + jugador.getPuntos());
        this.equipoJugador.add("\nUnidades:\n");
        for (Unidad u : jugador.getEjercito()) {
            this.equipoJugador.add(u.toString());
        }
    }

}
