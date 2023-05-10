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
    private int posicionMaxima;

    /**
     * Constructor de objetos de clase Escenario
     *
     * @param puntosIniciales Puntos que se otorgan a los jugadores al comienzo
     * @param posicionMaxima Valor máximo de los parametros de las coordenadas
     * (x e y)
     */
    public Escenario(int puntosIniciales, int posicionMaxima) {
        this.puntosIniciales = puntosIniciales;
        this.dimensionEscenario = new Unidad[posicionMaxima][posicionMaxima];
        this.posicionMaxima = posicionMaxima;
    }

    /**
     * Permite obtener el numero de puntos iniciales establecidos según el
     * escenario en el que se cree una partida para poder dar esa cantidad de
     * puntos a los jugadores.
     *
     * @return Numero de puntos iniciales
     */
    public int getPuntosIniciales() {
        return this.puntosIniciales;
    }

    /**
     * Permite obtener el valor maximo de los parametros (x e y) de la dimension
     * del escenario.
     *
     * @return Valor maximo
     */
    public int getPosicionMaxima() {
        return this.posicionMaxima;
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

    /**
     * Permite colocar una Unidad en una posicion del escenario
     *
     * @param unidad Unidad que se va a colocar
     * @param coordenada Posicion en la que se busca la unidad
     */
    public void setUnidadEscenario(Unidad unidad, Coordenada coordenada) {
        this.dimensionEscenario[coordenada.getX()][coordenada.getY()] = unidad;
    }

    /**
     * Permite vaciar la posición recibida como parametro
     *
     * @param coordenada Posicion a vacóiar
     */
    public void vaciarCasillaEscenario(Coordenada coordenada) {
        this.dimensionEscenario[coordenada.getX()][coordenada.getY()] = null;
    }

    /**
     * Este metodo determina si una coordenada esta dentro o fuera del mapa
     *
     * @param coordenada
     * @return true si la coordenada esta fuera del mapa
     */
    public Boolean fueraMapa(Coordenada coordenada) {
        Boolean resultado = false;

        if ((coordenada.getX() < 0)
                || (coordenada.getY() < 0)
                || (coordenada.getX() > this.posicionMaxima)
                || (coordenada.getY() > this.posicionMaxima)) {
            resultado = true;
        }
        return resultado;
    }

}
