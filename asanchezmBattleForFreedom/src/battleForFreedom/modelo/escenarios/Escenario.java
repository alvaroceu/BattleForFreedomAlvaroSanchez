package battleForFreedom.modelo.escenarios;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.Unidad;

/**
 *
 * @author Alvaro
 */
public abstract class Escenario {

    private int puntosIniciales;
    private Unidad[][] dimensionEscenario;

    /*
    *  Constructor, sera usado por las clases hijas
     */
    public Escenario(int puntosIniciales, int maximo) {
        this.puntosIniciales = puntosIniciales;
        this.dimensionEscenario = new Unidad[maximo][maximo];
    }

    public Unidad getUnidadEscenario(Coordenada coordenada) {
        int x = coordenada.getX();
        int y = coordenada.getY();
        return dimensionEscenario[x][y];
    }

}
