package battleForFreedom.modelo.tropas.seres;

import battleForFreedom.modelo.funcionamiento.Raza;

/**
 *
 * @author Alvaro
 */
public abstract class Ser {

    private int costeSer;
    private Raza raza;
    private int resistenciaAtaques;
    private int puntosAnulado;

    /*
    *  Constructor completo, se usara para las clases hijas de 'Ser'
     */
    public Ser(int coste, Raza raza, int resistencia, int puntos) {
        this.costeSer = coste;
        this.raza = raza;
        this.resistenciaAtaques = resistencia;
        this.puntosAnulado = puntos;
    }
}
