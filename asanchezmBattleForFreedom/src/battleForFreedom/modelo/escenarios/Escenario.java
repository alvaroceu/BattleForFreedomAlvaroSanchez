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

    /**
     * Constructor de objetos de clase Escenario
     *
     * @param puntosIniciales Puntos que se otorgan a los jugadores al comienzo
     * @param maximo Valor máximo de los parametros de las coordenadas (x e y)
     */
    public Escenario(int puntosIniciales, int maximo) {
        this.puntosIniciales = puntosIniciales;
        this.dimensionEscenario = new Unidad[maximo][maximo];
    }

    /**
     * Permite obtener la Unidad que se encuentra en una posicion del escenario
     *
     * @param coordenada Posicion en la que se busca la unidad
     * @return La Unidad en cuestion, o null en caso de ser una coordenada vacía
     */
    public Unidad getUnidadEscenario(Coordenada coordenada) {
        int x = coordenada.getX();
        int y = coordenada.getY();
        return dimensionEscenario[x][y];
    }

}
