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
    private int turno;
    private Jugador ganador;

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
        this.turno = 0;
        this.ganador = null;
    }

    /**
     * Constructor de objetos de la clase Partida, que crea también a los
     * jugadores
     *
     * @param escenarioPartida
     * @param jugadorHumano
     * @param jugadorNavi
     */
    public Partida(Escenario escenarioPartida, String jugadorHumano, String jugadorNavi) {
        this(new Jugador(jugadorHumano, escenarioPartida), new Jugador(jugadorNavi, escenarioPartida), escenarioPartida);
    }

}
