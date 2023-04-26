package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.seres.Ser;

/**
 *
 * @author Alvaro
 */
public abstract class Unidad {

    private int costeUnidad;
    private int energiaAtaque;
    private int energiaDefensa;
    private int energiaMovimiento;
    private int potenciaAtaque;
    private int puntosAnulado;
    private Coordenada posicion;
    private Ser[] seresUnidad;
    private Boolean unidadAnulada;

    /**
     * Constructor de objetos de la clase Unidad
     *
     * @param costeUnidad Puntos necesarios para comprar la unidad
     * @param energiaAtaque Energia necesaria para realizar los ataques
     * @param energiaDefensa Energia necesaria para recibir los ataques
     * @param energiaMovimiento Energia necesaria para mover la unidad
     * @param potenciaAtaque Cantidad que se resta de energia de ataque y
     * defensa
     * @param puntosAnulado Puntos que recibe el jugador que elimina la unidad
     * @param posicion Coordenadas de la unidad en el escenario
     * @param numeroSeres Numero de seres que controlan la unidad
     *
     */
    public Unidad(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, Coordenada posicion, int numeroSeres) {
        this.costeUnidad = costeUnidad;
        this.energiaAtaque = energiaAtaque;
        this.energiaDefensa = energiaDefensa;
        this.energiaMovimiento = energiaMovimiento;
        this.potenciaAtaque = potenciaAtaque;
        this.puntosAnulado = puntosAnulado;
        this.posicion = posicion;
        this.seresUnidad = new Ser[numeroSeres];
        this.unidadAnulada = false;
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
     *
     */
    public int atacar(Coordenada ataque, Escenario escenario) throws AtaqueException {
        int puntosGanados = 0;
        if (!enRangoAtaque(ataque)) {
            throw new AtaqueException("Fuera de rango");
        }
        if (this.energiaAtaque < this.potenciaAtaque) {
            throw new AtaqueException("Sin energía de ataque");
        }

        this.energiaAtaque = this.energiaAtaque - this.potenciaAtaque;

        if (escenario.getUnidadEscenario(ataque) == null) {
            throw new AtaqueException("Se ha atacado la posicion " + ataque + " pero estaba vacia");
        } else {
            if (escenario.getUnidadEscenario(ataque).unidadAnulada) {
                throw new AtaqueException("Se ha atacado la posicion " + ataque + " pero la unidad en dicha posicion ya estaba anulada");
            }

            puntosGanados = escenario.getUnidadEscenario(ataque).unidadRecibeAtaque(this.potenciaAtaque);
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
            float daño = (float) potenciaAtaque - (float) this.energiaDefensa / this.seresUnidad.length;
            this.energiaDefensa = 0;
            int seresDerrotados = 0;

            for (int numeroSer = this.seresUnidad.length - 1; numeroSer >= 0; numeroSer--) {

                if (this.seresUnidad[numeroSer].serDebePuntos(daño)) {
                    puntosGanados = puntosGanados + this.seresUnidad[numeroSer].getPuntosAnulado();
                }
                if (this.seresUnidad[numeroSer].serDerrotado()) {
                    seresDerrotados++;
                }
            }
            if (seresDerrotados == this.seresUnidad.length) {
                puntosGanados = puntosGanados + this.puntosAnulado;
                this.unidadAnulada = true;
            }
        }
        return puntosGanados;
    }

    /**
     * Este método determina si una coordenada se encuentra dentro del rango de
     * ataque de una unidad o no.En su interior aparece la funcion
     * comprobarRango que es la que indica el rango concreto de la unidad que
     * llame al método.
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
                || (coordenada.getY() > (this.posicion.getX() + maximoRango))) {

        }

        return rango;
    }
}
