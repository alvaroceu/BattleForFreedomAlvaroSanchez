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
     * Permite obtener la cantidad de puntos que se ganan al anular la unidad
     *
     * @returns Puntos ganados por anulacion.
     */
    public int getPuntosAnulado() {
        return puntosAnulado;
    }

}
