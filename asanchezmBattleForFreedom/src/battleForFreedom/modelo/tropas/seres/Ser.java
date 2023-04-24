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

    /*
    *  Constructor completo, se usara para las clases hijas de 'Ser'
     */
    public Ser(int coste, Raza raza, int resistencia, int puntos) {
        this.costeSer = coste;
        this.raza = raza;
        this.resistenciaAtaques = resistencia;
        this.puntosAnulado = puntos;
        this.serAnulado = false;
    }

    public void setResistenciaAtaques(float resistenciaAtaques) {
        this.resistenciaAtaques = resistenciaAtaques;
    }

    public float getResistenciaAtaques() {
        return resistenciaAtaques;
    }

    public void setSerAnulado(Boolean serAnulado) {
        this.serAnulado = serAnulado;
    }

    public int getPuntosAnulado() {
        return puntosAnulado;
    }

}
