package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.excepciones.CasillaOcupadaException;
import battleForFreedom.excepciones.EnergiaMovimientoException;
import battleForFreedom.excepciones.FueraMapaException;
import battleForFreedom.excepciones.PuntosInsuficientesException;
import battleForFreedom.excepciones.UnidadIncompletaException;
import battleForFreedom.modelo.Entidad;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.funcionamiento.Raza;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.seres.Ser;
import battleForFreedom.modelo.tropas.unidades.humanas.PlataformaMovilidadAmplificadaMitsubishiMK6;
import battleForFreedom.modelo.tropas.unidades.navi.Banshee;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Alvaro
 */
public abstract class Unidad extends Entidad {

    private int costeUnidad;
    private int energiaAtaque;
    private int energiaDefensa;
    private int energiaMovimiento;
    private int potenciaAtaque;
    private int puntosAnulado;
    private Coordenada posicion;
    private ArrayList<Ser> seresUnidad;
    private int numeroSeres;
    private Boolean unidadAnulada;
    private int gastoEnergia;
    private Raza raza;
    private Jugador propietario;

    /**
     * Constructor de objetos de la clase Unidad
     *
     * @param costeUnidad Puntos necesarios para comprar la unidad
     * @param energiaAtaque Energia necesaria para realizar los ataques
     * @param energiaDefensa Energia necesaria para recibir los ataques
     * @param energiaMovimiento Energia necesaria para mover la unidad
     * @param potenciaAtaque Cantidad que se resta de energia de ataque y
     * defensa.
     * @param puntosAnulado Puntos que recibe el jugador que elimina la unidad
     * @param gastoEnergia Energia gastada al moverse
     * @param raza Raza de la unidad (humano, navi)
     *
     */
    public Unidad(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, int gastoEnergia, Raza raza, int numeroSeres, Jugador jugador) {
        this.costeUnidad = costeUnidad;
        this.energiaAtaque = energiaAtaque;
        this.energiaDefensa = energiaDefensa;
        this.energiaMovimiento = energiaMovimiento;
        this.potenciaAtaque = potenciaAtaque;
        this.puntosAnulado = puntosAnulado;
        this.posicion = null;
        this.seresUnidad = new ArrayList();
        this.gastoEnergia = gastoEnergia;
        this.unidadAnulada = false;
        this.raza = raza;
        this.numeroSeres = numeroSeres;
        this.propietario = jugador;
    }

    /**
     * Este metodo permite a una unidad realizar un ataque.En caso de acertar el
     * ataque, se llama al método unidadRecibeAtaque.
     *
     * @param ataque Coordenada a la que se dirige el ataque
     * @param escenario Escenario empleado en la partida actual
     *
     * @throws AtaqueException Siempre que falle el ataque por cualquier
     * motivo(rango, energía, posición vacía)
     *
     * @return Puntos obtenidos en caso de haberse derrotado seres o la unidad
     * @throws battleForFreedom.excepciones.UnidadIncompletaException
     *
     */
    public int atacar(Coordenada ataque, Escenario escenario, Jugador rival) throws AtaqueException, UnidadIncompletaException, FueraMapaException {

        if (escenario.fueraMapa(ataque)) {
            throw new FueraMapaException();
        }

        int puntosGanados = 0;
        if (!this.unidadCompleta()) {
            throw new UnidadIncompletaException();
        }
        if (!this.enRangoAtaque(ataque)) {
            throw new AtaqueException("Fuera de rango");
        }
        if (this.energiaAtaque < this.potenciaAtaque) {
            throw new AtaqueException("Sin energía de ataque");
        }

        this.energiaAtaque = this.energiaAtaque - this.potenciaAtaque;

        if (escenario.getUnidadEscenario(ataque) == null) {
            this.propietario.actualizarCentroMandos("Se ha atacado a la posicion: " + ataque + "pero estaba vacia" + " [" + new Date() + "]");
            rival.actualizarCentroMandos("El rival ha atacado a la posicion: " + ataque + "pero estaba vacia" + " [" + new Date() + "]");
            throw new AtaqueException("Se ha atacado la posicion " + ataque + " pero estaba vacia");
        } else {
            if (escenario.getUnidadEscenario(ataque).unidadAnulada) {
                this.propietario.actualizarCentroMandos("Se ha atacado a la posicion: " + ataque + " pero la unidad " + escenario.getUnidadEscenario(ataque).tipoUnidad() + " ya estaba anulada" + " [" + new Date() + "]");
                rival.actualizarCentroMandos("El rival ha atacado a la posicion: " + ataque + " pero la unidad " + escenario.getUnidadEscenario(ataque).tipoUnidad() + " ya estaba anulada" + " [" + new Date() + "]");
                throw new AtaqueException("Se ha atacado la posicion " + ataque + " pero la unidad en dicha posicion ya estaba anulada");
            }

            puntosGanados = escenario.getUnidadEscenario(ataque).unidadRecibeAtaque(this.potenciaAtaque);
            String fuegoAmigo;
            if (this.propietario == escenario.getUnidadEscenario(ataque).propietario) {
                fuegoAmigo = "Fuego Amigo";
            } else {
                fuegoAmigo = "No Fuego Amigo";
            }

            this.propietario.actualizarCentroMandos("Se ha atacado a la posicion: " + ataque + " donde habia un(a) " + escenario.getUnidadEscenario(ataque).tipoUnidad() + "(" + fuegoAmigo + ")" + " [" + new Date() + "]");
            rival.actualizarCentroMandos("El rival ha atacado a la posicion: " + ataque + " donde habia un(a) " + escenario.getUnidadEscenario(ataque).tipoUnidad() + "(" + fuegoAmigo + ")" + " [" + new Date() + "]");
        }

        return puntosGanados;
    }

    /**
     * Este método permite a una unidad recibir un ataque con las consecuencias
     * que conlleva (unidad o seres anulados, puntos ganados por anulación)
     *
     * @param potenciaAtaque Potencia del ataque recibido
     *
     * @return Puntos ganados con la anulacion de seres o la unidad
     */
    public int unidadRecibeAtaque(int potenciaAtaque) {
        int puntosGanados = 0;

        if (this.energiaDefensa >= potenciaAtaque) {
            this.energiaDefensa = this.energiaDefensa - potenciaAtaque;
            System.out.println("Se ha atacado la posicion " + this.posicion + " donde habia un(a)"); //falta implementar el tipo de unidad
        } else {
            float daño = ((float) potenciaAtaque - (float) this.energiaDefensa) / this.seresUnidad.size();
            this.energiaDefensa = 0;
            int seresDerrotados = 0;

            for (Ser ser : this.seresUnidad) {

                if (ser.serDebePuntos(daño)) {
                    puntosGanados = puntosGanados + ser.getPuntosAnulado();
                }
                if (ser.serDerrotado()) {
                    seresDerrotados++;
                }
            }
            if (seresDerrotados == this.seresUnidad.size()) {
                puntosGanados = puntosGanados + this.puntosAnulado;
                this.unidadAnulada = true;
            }
        }
        return puntosGanados;
    }

    /**
     * Este método determina si una coordenada se encuentra dentro del rango de
     * ataque de una unidad o no.En su interior aparece la funcion
     * comprobarRangoAtaque que es la que indica el rango concreto de la unidad
     * que llame al método.
     *
     * @param coordenada Coordenada a determinar.
     *
     * @return True si esta en rango, false si no lo esta.
     *
     */
    public abstract Boolean enRangoAtaque(Coordenada coordenada);

    /**
     * Este método es un método auxiliar para el método enRangoAtaque, y es el
     * que determina si una coordenada dada se encuentra o no en el rango de
     * ataque de dicha unidad
     *
     * @param coordenada Coordenada a determinar
     * @param maximoRango Distancia de alcance de los ataques de la unidad
     *
     * @return True si esta en rango, false si no lo esta
     */
    public Boolean comprobarRangoAtaque(Coordenada coordenada, int maximoRango) {
        Boolean rango = true;

        if ((coordenada.getX() < (this.posicion.getX() - maximoRango))
                || (coordenada.getX() > (this.posicion.getX() + maximoRango))
                || (coordenada.getY() < (this.posicion.getY() - maximoRango))
                || (coordenada.getY() > (this.posicion.getY() + maximoRango))) {
            rango = false;
        }

        return rango;
    }

    /**
     * Este metodo permite a una unidad moverse a una coordenada
     *
     * @param escenario Escenario en el que se mueve la unidad
     * @throws EnergiaMovimientoException La unidad no tiene suficiente energía
     * de movimiento
     * @throws battleForFreedom.excepciones.CasillaOcupadaException La casilla a
     * la que se pretende mover ya esta ocupada
     * @throws battleForFreedom.excepciones.UnidadIncompletaException
     */
    public void mover(Escenario escenario) throws EnergiaMovimientoException, CasillaOcupadaException, UnidadIncompletaException, FueraMapaException {

        if (!this.unidadCompleta()) {
            throw new UnidadIncompletaException();
        }

        Coordenada nuevaPosicion = null;
        if (this instanceof Banshee) {
            nuevaPosicion = new Coordenada(escenario);
        } else {
            nuevaPosicion = establecerCoordenadaMovimiento();
        }

        if (escenario.fueraMapa(nuevaPosicion)) {
            throw new FueraMapaException();
        }

        int horizontal = Math.abs(this.posicion.getX() - nuevaPosicion.getX());
        int vertical = Math.abs(this.posicion.getY() - nuevaPosicion.getY());

        if ((this instanceof PlataformaMovilidadAmplificadaMitsubishiMK6) || (this instanceof Banshee)) {
            if (this.gastoEnergia > this.energiaMovimiento) {
                throw new EnergiaMovimientoException(this.energiaMovimiento, this.gastoEnergia);
            } else {

                if (escenario.getUnidadEscenario(nuevaPosicion) != null) {
                    throw new CasillaOcupadaException();
                }

                this.energiaMovimiento = this.energiaMovimiento - this.gastoEnergia;
                this.moverUnidadCasilla(escenario, nuevaPosicion);
            }
        } else {
            if (((horizontal + vertical) * this.gastoEnergia) > this.energiaMovimiento) {
                throw new EnergiaMovimientoException(this.energiaMovimiento, this.gastoEnergia);
            } else {

                if (escenario.getUnidadEscenario(nuevaPosicion) != null) {
                    throw new CasillaOcupadaException();
                }

                this.energiaMovimiento = this.energiaMovimiento - ((horizontal + vertical) * this.gastoEnergia);
                this.moverUnidadCasilla(escenario, nuevaPosicion);
            }
        }
        this.propietario.actualizarCentroMandos("Se ha movido a la unidad " + this.tipoUnidad() + " a la posicion: " + this.posicion + " [" + new Date() + "]");
    }

    /**
     * Este método cambia la posición de una unidad una vez que se ha realizado
     * el método mover, y actualiza el escenario, quitando a la unidad de la
     * antigua posición y añadiéndola en la nueva.
     *
     * @param escenario
     * @param nuevaPosicion
     */
    public void moverUnidadCasilla(Escenario escenario, Coordenada nuevaPosicion) {
        escenario.vaciarCasillaEscenario(this.posicion);
        this.posicion = nuevaPosicion;
        escenario.setUnidadEscenario(this, nuevaPosicion);
    }

    /**
     * Este método devuelve una coordenada que se encuentra dentro de las
     * limitaciones de movimiento de una unidad concreta.Dicha coordenada la
     * genera en primer lugar otro método.
     *
     *
     * @return Coordenada a la que se moverá la unidad
     *
     */
    public abstract Coordenada establecerCoordenadaMovimiento();

    /**
     * Este método genera una coordenada aleatoria dentro del rango de
     * movimiento de una unidad.
     *
     * @param maximoMovimiento Numero maximo de casillas avanzadas en un
     * movimiento
     *
     * @return Coordenada a la que se moverá la unidad
     */
    public Coordenada generarCoordenadaMovimiento(int maximoMovimiento) {

        int xActual;
        int yActual;

        do {
            xActual = this.posicion.getX();
            yActual = this.posicion.getY();
            Random r = new Random();
            int eleccion;

            for (int i = maximoMovimiento; i > 0; i--) {

                eleccion = r.nextInt(5);

                if (eleccion == 0) {
                    xActual++;
                } else if (eleccion == 1) {
                    yActual++;
                } else if (eleccion == 2) {
                    xActual--;
                } else if (eleccion == 3) {
                    yActual--;
                }

            }
        } while ((xActual == this.posicion.getX()) && (yActual == this.posicion.getY()));

        return new Coordenada(xActual, yActual);
    }

    /**
     * Método que realiza la resta de puntos de la compra de una unidad, y añade
     * la unidad al escenario en caso de haberse comprado correctamente
     *
     * @param puntosDisponibles Puntos actuales del jugador
     * @param escenario Escenario de la partida actual
     *
     * @return Puntos finales del jugador tras descontar el coste de la unidad
     *
     * @throws PuntosInsuficientesException si no hay sificientes puntos para
     * comprar
     */
    public int compraDeUnidad(int puntosDisponibles, Escenario escenario) throws PuntosInsuficientesException {
        if (puntosDisponibles < this.costeUnidad) {
            throw new PuntosInsuficientesException();
        } else {
            puntosDisponibles = puntosDisponibles - this.costeUnidad;
        }
        return puntosDisponibles;
    }

    /**
     * Este método establece la posición de un ser a una coordenada que se
     * encuentre vacía en el escenario, después de haber comprobado (en un
     * método de otra clase) que la unidad tiene a todos sus seres.
     *
     * @param escenario Escenario en el cual se coloca a la unidad
     */
    public void colocarUnidad(Escenario escenario) {
        do {
            this.posicion = new Coordenada(escenario);
        } while (escenario.getUnidadEscenario(this.posicion) != null);

        escenario.setUnidadEscenario(this, this.posicion);

    }

    /**
     * Este método añade un ser que ya ha sido comprado a una unidad.Primero
     * busca una posicion vacía dentro del ser, y cuando la encuentra se
     * coloca.Después una variable Boolean (salirDelBucle) cambia su valor a
     * "true" para que no se añada dicho ser en otras posiciones vacías de la
     * unidad.Por ultimo comprueba si la unidad en la que se ha añadido un ser
     * ya esta completa o no.En caso de estarlo, la funcion devuelve true
     *
     * @param serAñadido Ser colocado en la unidad
     *
     * @return unidadCompleta True si la unidad se ha llenado al colocar el
     * ultimo ser
     */
    public Boolean añadirSer(Ser serAñadido) {
        this.seresUnidad.add(serAñadido);

        return this.unidadCompleta();
    }

    /**
     * Permite saber si una unidad esta llena de seres o no
     *
     * @return true si esta completa
     */
    public Boolean unidadCompleta() {
        Boolean unidadCompleta = false;

        if (this.seresUnidad.size() == this.numeroSeres) {
            unidadCompleta = true;
        }

        return unidadCompleta;
    }

    /**
     * Metodo toString que muestra la energia de ataque, defensa y posicion de
     * una unidad
     *
     * @return cadena con dicha informacion
     */
    @Override
    public String toString() {
        return " ATK:(" + this.energiaAtaque + ")" + " DEF:(" + this.energiaDefensa + ")" + " POS:" + this.posicion;
    }

    /**
     * Permitirá recibir el tipo de unidad
     *
     * @return
     */
    public abstract String tipoUnidad();

    /**
     * Método similar a toString, pero que muestra toda la información de la
     * unidad
     *
     * @return cadena con dicha información
     */
    public String datosCompletos() {
        return this.toString() + " MOV:(" + this.energiaMovimiento + ")" + " POT.ATK:(" + this.potenciaAtaque + ")" + " OWNER:(" + this.propietario + ")";
    }

}
