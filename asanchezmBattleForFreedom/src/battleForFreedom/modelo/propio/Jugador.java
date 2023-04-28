package battleForFreedom.modelo.propio;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.excepciones.CasillaOcupadaException;
import battleForFreedom.excepciones.EnergiaMovimientoException;
import battleForFreedom.excepciones.FueraDeRangoException;
import battleForFreedom.excepciones.PuntosInsuficientesException;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.Unidad;

/**
 *
 * @author Alvaro
 */
public class Jugador {

    private String ID;
    private Equipo equipo;

    /**
     * Constructor de objetos de clase Jugador
     *
     * @param Id Nombre o identificación del jugador
     * @param equipo Equipo del jugador
     */
    public Jugador(String Id, Equipo equipo) {
        this.ID = Id;
        this.equipo = equipo;
    }

    /**
     * Este método llama al método atacar de la clase Unidad para realizar un
     * ataque con una unidad del jugador, a una coordenada concreta.Almacena la
     * suma de puntos del usuario antes de realizar el ataque más los puntos
     * ganados al anular unidades o seres en dicho ataque (en caso de
     * conseguirlo).
     *
     * @param escenario Escenario de la partida actual
     */
    public void realizarAtaque(Escenario escenario, Coordenada coordenadaAtaque, Unidad unidad) throws AtaqueException {
        int puntosActuales = this.equipo.getPuntosDisponibles();
        int puntosGanados = unidad.atacar(coordenadaAtaque, escenario);
        int puntosFinales = puntosActuales + puntosGanados;
        this.equipo.setPuntosDisponibles(puntosFinales);
    }

    /**
     * Este método llama al método atacar de la clase Unidad para realizar un
     * ataque con una unidad del jugador, a una coordenada concreta.Almacena la
     * suma de puntos del usuario antes de realizar el ataque más los puntos
     * ganados al anular unidades o seres en dicho ataque (en caso de
     * conseguirlo).
     *
     * @param escenario Escenario de la partida actual
     */
    public void moverUnidad(Escenario escenario, Unidad unidad) throws EnergiaMovimientoException, FueraDeRangoException, CasillaOcupadaException {
        unidad.mover(new Coordenada(escenario), escenario);
    }

    /**
     * Este método permite comprar un unidad recibida como parámetro, obteniendo
     * los puntos finales que tendrá el usuario tras comprar la unidad, y
     * añadiendo la unidad comprada a la lista de unidades del jugador, y al
     * escenario.
     *
     * @param unidadAComprar
     * @param escenario
     * @throws PuntosInsuficientesException
     */
    public void comprarUnidad(Unidad unidadAComprar, Escenario escenario) throws PuntosInsuficientesException {
        int nuevosPuntos = unidadAComprar.compraDeUnidad(this.equipo.getPuntosDisponibles(), escenario);
        this.equipo.setPuntosDisponibles(nuevosPuntos);
        this.equipo.getEjercito().getUnidades().add(unidadAComprar);
    }

    /**
     * Representación de la clase Jugador.
     *
     * @return Cadena que indica el nombre o ID del jugador
     */
    @Override
    public String toString() {
        return "Jugador: " + this.ID;
    }

}
