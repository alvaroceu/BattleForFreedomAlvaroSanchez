package battleForFreedom.modelo.propio;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.excepciones.CasillaOcupadaException;
import battleForFreedom.excepciones.EnergiaMovimientoException;
import battleForFreedom.excepciones.PuntosInsuficientesException;
import battleForFreedom.excepciones.UnidadIncompletaException;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.seres.Ser;
import battleForFreedom.modelo.tropas.unidades.Unidad;
import java.util.ArrayList;

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
     * @param escenario
     */
    public Jugador(String Id, Escenario escenario) {
        this.ID = Id;
        this.equipo = new Equipo(escenario.getPuntosIniciales());
    }

    /**
     * Este método permite acceder a la lista de unidades del jugador, usado en
     * la interfaz para los diferentes métodos que la componen
     *
     * @return lista de unidades del jugador
     */
    public ArrayList<Unidad> getUnidadesJugador() {
        return this.equipo.getEjercito().getUnidades();
    }

    /**
     * Este método llama al método atacar de la clase Unidad para realizar un
     * ataque con una unidad del jugador, a una coordenada concreta.Almacena la
     * suma de puntos del usuario antes de realizar el ataque más los puntos
     * ganados al anular unidades o seres en dicho ataque (en caso de
     * conseguirlo).
     *
     * @param escenario Escenario de la partida actual
     * @param coordenadaAtaque Coordenada a la que se realizará el ataque
     * @param unidad Unidad que realiza el ataque
     *
     * @throws battleForFreedom.excepciones.AtaqueException
     * @throws battleForFreedom.excepciones.UnidadIncompletaException
     */
    public void realizarAtaque(Escenario escenario, Coordenada coordenadaAtaque, Unidad unidad) throws AtaqueException, UnidadIncompletaException {
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
     * @param unidad Unidad que se moverá
     *
     * @throws battleForFreedom.excepciones.EnergiaMovimientoException
     * @throws battleForFreedom.excepciones.CasillaOcupadaException
     * @throws battleForFreedom.excepciones.UnidadIncompletaException
     */
    public void moverUnidad(Escenario escenario, Unidad unidad) throws EnergiaMovimientoException, CasillaOcupadaException, UnidadIncompletaException {
        unidad.mover(escenario);
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
     * Este método permite comprar un ser recibida como parámetro, obteniendo
     * los puntos finales que tendrá el usuario tras comprar el ser, y añadiendo
     * el ser comprado a la unidad sobre la que se encuentra
     *
     * @param unidadBajoSeres Unidad que controlarán los seres comprados
     * @param serAComprar Ser que se pretende comprar
     * @param escenario
     *
     * @throws PuntosInsuficientesException
     */
    public void comprarSer(Unidad unidadBajoSeres, Ser serAComprar, Escenario escenario) throws PuntosInsuficientesException {
        int nuevosPuntos = serAComprar.compraDeSer(this.equipo.getPuntosDisponibles(), escenario);
        this.equipo.setPuntosDisponibles(nuevosPuntos);
        Boolean unidadCompleta = unidadBajoSeres.añadirSer(serAComprar);

        if (unidadCompleta) {
            unidadBajoSeres.colocarUnidad(escenario);
        }
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
