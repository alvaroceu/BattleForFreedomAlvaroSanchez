package battleForFreedom.modelo.funcionamiento;

import java.util.Random;

/**
 *
 * @author Alvaro
 */
public class Coordenada {

    private int x;
    private int y;

    /*
    *  Constructor, genera una coordenada aleatoria
    *  dentro del rango maximo que recibe como parametro
     */
    public Coordenada(int maximo) {
        Random r = new Random();
        this.x = r.nextInt(maximo);
        this.y = r.nextInt(maximo);
    }
}
