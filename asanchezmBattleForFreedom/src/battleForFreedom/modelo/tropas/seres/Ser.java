package battleForFreedom.modelo.tropas.seres;

import battleForFreedom.excepciones.PuntosInsuficientesException;
import battleForFreedom.modelo.Entidad;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Raza;

/**
 *
 * @author Alvaro
 */
public abstract class Ser extends Entidad {

    private int costeSer;
    private Raza raza;
    private float resistenciaAtaques;
    private int puntosAnulado;
    private Boolean serAnulado;

    /**
     * Constructor de objetos de la clase Ser.
     *
     * @param coste Puntos necesarios para comprar el ser
     * @param raza Humano o Na'vi
     * @param resistencia Aguante frente a ataques
     * @param puntos Puntos obtenidos al anular la unidad
     *
     */
    public Ser(int coste, Raza raza, int resistencia, int puntos) {
        this.costeSer = coste;
        this.raza = raza;
        this.resistenciaAtaques = resistencia;
        this.puntosAnulado = puntos;
        this.serAnulado = false;
    }

    /**
     * Este método permite saber si un ser debe puntos al jugador atacante, es
     * decir, si ha sido derrotado en ese mismo turno.Si el ser no es anulado
     * después del ataque, o el ser ya estaba anulado desde un principio, no
     * deberá puntos
     *
     * @param daño Daño que recibe el ser (potencia de ataque / numero de seres)
     *
     * @return True si el ser debe puntos, false si no
     */
    public Boolean serDebePuntos(float daño) {
        Boolean recompensa = false;

        if (this.resistenciaAtaques > 0) {
            this.resistenciaAtaques = this.resistenciaAtaques - daño;

            if (this.resistenciaAtaques <= 0) {
                this.serAnulado = true;
                recompensa = true;
            }
        }

        return recompensa;
    }

    /**
     * Este método permite saber si un ser ha sido derrotado o no
     *
     * @return True si ha sido derrotado, false si no
     */
    public Boolean serDerrotado() {
        return this.serAnulado;
    }

    /**
     * Permite obtener la cantidad de puntos que se ganan al anular la unidad
     *
     * @return Puntos ganados por anulacion.
     */
    public int getPuntosAnulado() {
        return puntosAnulado;
    }

    /**
     * Método que realiza la resta de puntos de la compra de un ser
     *
     * @param puntosDisponibles Puntos actuales del jugador
     * @param escenario Escenario de la partida actual
     *
     * @return Puntos finales del jugador tras descontar el coste del ser
     *
     * @throws PuntosInsuficientesException si no hay sificientes puntos para
     * comprar
     */
    public int compraDeSer(int puntosDisponibles, Escenario escenario) throws PuntosInsuficientesException {
        if (puntosDisponibles < this.costeSer) {
            throw new PuntosInsuficientesException();
        } else {
            puntosDisponibles = puntosDisponibles - this.costeSer;
        }
        return puntosDisponibles;
    }

}
