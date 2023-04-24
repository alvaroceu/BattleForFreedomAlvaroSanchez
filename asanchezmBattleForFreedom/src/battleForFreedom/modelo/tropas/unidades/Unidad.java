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
     * Este metodo permite cambiar el valor de unidadAnulada.
     *
     * @param unidadAnulada Nuevo valor (true,false)
     *
     */
    public void setUnidadAnulada(Boolean unidadAnulada) {
        this.unidadAnulada = unidadAnulada;
    }

    /**
     * Este metodo permite a una unidad realizar un ataque.En caso de acertar el
     * ataque, se reduce la enería de ataque de la unidad atacante, así cómo la
     * energía de defensa de la defensora, o bien la resistencia de los seres en
     * caso de haberse agotado la defensa de la unidad.
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

            if (escenario.getUnidadEscenario(ataque).energiaDefensa >= this.potenciaAtaque) {
                escenario.getUnidadEscenario(ataque).energiaDefensa = escenario.getUnidadEscenario(ataque).energiaDefensa - this.potenciaAtaque;
                System.out.println("Se ha atacado la posicion " + ataque + " donde habia un(a)"); //falta implementar el tipo de unidad
            } else {
                escenario.getUnidadEscenario(ataque).energiaDefensa = 0;

                float daño = (float) this.potenciaAtaque - escenario.getUnidadEscenario(ataque).energiaDefensa / escenario.getUnidadEscenario(ataque).seresUnidad.length;
                escenario.getUnidadEscenario(ataque).energiaDefensa = 0;
                int seresDerrotados = 0;

                for (int numeroSer = escenario.getUnidadEscenario(ataque).seresUnidad.length - 1; numeroSer >= 0; numeroSer--) {
                    float vidaSer = escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].getResistenciaAtaques();

                    if (vidaSer > 0) {
                        vidaSer = vidaSer - daño;
                        escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].setResistenciaAtaques(vidaSer);

                        if (vidaSer <= 0) {
                            escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].setSerAnulado(true);
                            puntosGanados = puntosGanados + escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].getPuntosAnulado();
                        }
                    }

                    if (vidaSer <= 0) {
                        seresDerrotados++;
                    }

                }

                if (seresDerrotados == escenario.getUnidadEscenario(ataque).seresUnidad.length) {
                    puntosGanados = puntosGanados + escenario.getUnidadEscenario(ataque).puntosAnulado;
                    escenario.getUnidadEscenario(ataque).setUnidadAnulada(true);
                }

            }
        }

        return puntosGanados;
    }

    /**
     * Este método determina si una coordenada se encuentra dentro del rango de
     * ataque de una unidad o no.
     *
     * @param coordenada Coordenada a determinar.
     *
     * @return True si esta en rango, false si no lo esta.
     *
     */
    public abstract Boolean enRangoAtaque(Coordenada coordenada);
}
