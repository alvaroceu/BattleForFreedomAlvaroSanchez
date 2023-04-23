package battleForFreedom.modelo.escenarios;

/**
 *
 * @author Alvaro
 */
public abstract class Escenario {

    private int puntosIniciales;
    private int[][] dimensionEscenario;

    /*
    *  Constructor completo, sera usado por las clases hijas
     */
    public Escenario(int puntosIniciales, int[][] dimension) {
        this.dimensionEscenario = dimension;
        this.puntosIniciales = puntosIniciales;
    }

}
