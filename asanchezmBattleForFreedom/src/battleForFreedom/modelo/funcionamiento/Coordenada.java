package battleForFreedom.modelo.funcionamiento;

import java.util.Random;

/**
 *
 * @author Alvaro
 */
public class Coordenada {

    private int x;
    private int y;

    /**
     * Constructor que genera una coordenada aleatoria dentro del rango maximo
     * que recibe como parametro.
     *
     * @param maximo Rngo maximo
     *
     */
    public Coordenada(int maximo) {
        Random r = new Random();
        this.x = r.nextInt(maximo);
        this.y = r.nextInt(maximo);
    }

    /**
     * Constructor que genera una coordenada con los valores indicados.
     *
     * @param x Valor del parametro x.
     * @param y Valor del parametro y.
     */
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return Posicion X de una coordenada
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return Posicion Y de una coordenada
     */
    public int getY() {
        return y;
    }

    /**
     * Representacion de Coordenada.
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
