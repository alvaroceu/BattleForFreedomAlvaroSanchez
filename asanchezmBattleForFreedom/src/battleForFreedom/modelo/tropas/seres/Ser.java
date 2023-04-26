package battleForFreedom.modelo.tropas.seres;

import battleForFreedom.modelo.funcionamiento.Raza;

/**
 *
 * @author Alvaro
 */
public abstract class Ser {

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
     * Permite modificar el valor de la resistencia frente a ataques.
     *
     * @param resistenciaAtaques Nuevo valor
     */
    public void setResistenciaAtaques(float resistenciaAtaques) {
        this.resistenciaAtaques = resistenciaAtaques;
    }

    /**
     * Permite obtener el valor de la resistencia frente a ataques.
     *
     * @return valor de la resistencia frente a ataques.
     */
    public float getResistenciaAtaques() {
        return resistenciaAtaques;
    }

    /**
     * Permite modificar el valor de serAnulado (True = ser anulado , False =
     * ser NO anulado)
     *
     * @param serAnulado Nuevo valor (true, false)
     */
    public void setSerAnulado(Boolean serAnulado) {
        this.serAnulado = serAnulado;
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
     * @returns Puntos ganados por anulacion.
     */
    public int getPuntosAnulado() {
        return puntosAnulado;
    }

}
