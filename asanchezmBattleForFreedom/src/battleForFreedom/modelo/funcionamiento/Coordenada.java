package battleForFreedom.modelo.funcionamiento;

import battleForFreedom.modelo.Entidad;
import battleForFreedom.modelo.escenarios.Escenario;
import java.util.Random;

/**
 *
 * @author Alvaro
 */
public class Coordenada extends Entidad {

    private int x;
    private int y;

    /**
     * Constructor que genera una coordenada aleatoria dentro del rango maximo
     * que recibe como parametro.
     *
     * @param maximo Rngo maximo
     */
    public Coordenada(int maximo) {
        Random r = new Random();
        this.x = r.nextInt(maximo);
        this.y = r.nextInt(maximo);
    }

    /**
     * Constructor que genera una coordenada aleatoria dentro del rango maximo
     * establecido por la posicion maxima del escenario recibido como parametro
     *
     * @param escenario del cual se obtiene la posicion máxima.
     */
    public Coordenada(Escenario escenario) {
        this(escenario.getPosicionMaxima());
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

    /**
     * Método equals de la clase Coordenada para poder determinar si dos
     * coordenadas dadas son iguales o no.
     *
     * @param o Objeto recibido (Coordenada)
     * @return true si son iguales
     */
    @Override
    public boolean equals(Object o) {
        boolean resultado = false;
        if (o == null) {
        }
        if (o instanceof Coordenada) {
            if ((((Coordenada) o).x == this.x) && (((Coordenada) o).y == this.y)) {
                resultado = true;
            }
        }
        return true;
    }
}
