package battleForFreedom.modelo.propio;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.excepciones.CasillaOcupadaException;
import battleForFreedom.excepciones.EnergiaMovimientoException;
import battleForFreedom.excepciones.FueraMapaException;
import battleForFreedom.excepciones.PuntosInsuficientesException;
import battleForFreedom.excepciones.UnidadIncompletaException;
import battleForFreedom.modelo.Entidad;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.seres.Ser;
import battleForFreedom.modelo.tropas.unidades.Unidad;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class Jugador extends Entidad {

    private String ID;
    private int puntosDisponibles;
    private ArrayList<Unidad> ejercito;
    private CentroDeMandos centroDeMandos;

    /**
     * Constructor de objetos de clase Jugador
     *
     * @param Id Nombre o identificación del jugador.
     * @param escenario
     * @param puntosDisponibles
     */
    public Jugador(String Id, Escenario escenario, int puntosDisponibles) {
        this.ID = Id;
        this.puntosDisponibles = puntosDisponibles;
        this.ejercito = new ArrayList();
        this.centroDeMandos = new CentroDeMandos();
    }

    /**
     * Permite obtener la lista de Unidades del ejército de cada equipo.
     *
     * @return Lista de unidades
     */
    public ArrayList<Unidad> getEjercito() {
        return ejercito;
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
     * Permite obtener los puntos del jugador
     *
     * @return puntos en cuestión
     */
    public int getPuntos() {
        return this.puntosDisponibles;
    }

    /**
     * Método que permite añadir un mensaje a la lista de mensajes del centro de
     * mandos.
     *
     * @param mensaje mensaje en cuestión
     */
    public void actualizarCentroMandos(String mensaje) {
        this.centroDeMandos.actualizarMensajes(mensaje);
    }

    /**
     * Método que permite obtener la lista de unidades del centro de comandos
     * que contiene toda la información de las mismas
     *
     * @return unidades en cuestión
     */
    public ArrayList<String> getEquipoCentroMandos() {
        return this.centroDeMandos.getEquipoJugador(this);
    }

    /**
     * Método que permite obtener la lista de mensajes del centro de mandos que
     * se van añadiendo al jugar
     *
     * @return mensajes en cuestión
     */
    public ArrayList<String> getMensajesCentroMandos() {
        return this.centroDeMandos.getMensajes();
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
     * @param rival Jugador rival del que atacará
     *
     * @throws battleForFreedom.excepciones.AtaqueException
     * @throws battleForFreedom.excepciones.UnidadIncompletaException
     * @throws battleForFreedom.excepciones.FueraMapaException
     */
    public void realizarAtaque(Escenario escenario, Coordenada coordenadaAtaque, Unidad unidad, Jugador rival) throws AtaqueException, UnidadIncompletaException, FueraMapaException {
        int puntosActuales = this.puntosDisponibles;
        int puntosGanados = unidad.atacar(coordenadaAtaque, escenario, rival);
        int puntosFinales = puntosActuales + puntosGanados;
        this.setPuntosDisponibles(puntosFinales);
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
     * @param rival Jugador rival del que moverá
     *
     * @throws battleForFreedom.excepciones.EnergiaMovimientoException
     * @throws battleForFreedom.excepciones.CasillaOcupadaException
     * @throws battleForFreedom.excepciones.UnidadIncompletaException
     * @throws battleForFreedom.excepciones.FueraMapaException
     */
    public void moverUnidad(Escenario escenario, Unidad unidad, Jugador rival) throws EnergiaMovimientoException, CasillaOcupadaException, UnidadIncompletaException, FueraMapaException {
        unidad.mover(escenario);
        rival.actualizarCentroMandos("El rival ha movido a la unidad " + unidad.tipoUnidad() + " [" + new Date() + "]");
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
        int nuevosPuntos = unidadAComprar.compraDeUnidad(this.puntosDisponibles, escenario);
        this.setPuntosDisponibles(nuevosPuntos);
        this.ejercito.add(unidadAComprar);
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
        int nuevosPuntos = serAComprar.compraDeSer(this.puntosDisponibles, escenario);
        this.setPuntosDisponibles(nuevosPuntos);
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
