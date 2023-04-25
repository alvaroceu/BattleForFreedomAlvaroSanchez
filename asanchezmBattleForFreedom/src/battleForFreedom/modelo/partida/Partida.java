package battleForFreedom.modelo.partida;

import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.propio.Jugador;

/**
 *
 * @author Alvaro
 */
public class Partida {

    private Jugador jugador1;
    private Jugador jugador2;
    private Escenario escenarioPartida;

    /**
     * Constructor de objetos de la clase Partida
     *
     * @param jugador1
     * @param jugador2
     * @param escenarioPartida
     */
    public Partida(Jugador jugador1, Jugador jugador2, Escenario escenarioPartida) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.escenarioPartida = escenarioPartida;
    }

}
