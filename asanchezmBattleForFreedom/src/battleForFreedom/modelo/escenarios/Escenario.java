package battleForFreedom.modelo.escenarios;

/**
 *
 * @author Alvaro
 */
public abstract class Escenario {

    private int puntosIniciales;
    private int[][] dimensionEscenario;

    /*
    *  Constructor, sera usado por las clases hijas
     */
    public Escenario(int puntosIniciales, int maximo) {
        this.puntosIniciales = puntosIniciales;
        this.dimensionEscenario = new int[maximo][maximo];
    }

}
