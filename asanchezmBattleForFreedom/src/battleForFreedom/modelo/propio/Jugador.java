package battleForFreedom.modelo.propio;

import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import static battleForFreedom.utiles.Utiles.leerEntero;

/**
 *
 * @author Alvaro
 */
public class Jugador {

    private String ID;
    private Equipo equipo;

    /**
     * Constructor de objetos de clase Jugador
     *
     * @param Id Nombre o identificación del jugador
     * @param equipo Equipo del jugador
     */
    public Jugador(String Id, Equipo equipo) {
        this.ID = Id;
        this.equipo = equipo;
    }

    /**
     * Método que permite seleccionar una coordenada concreta.El usuario debe
     * introducir el valor de X y de Y, comprendidos entre 1 y el maximo posible
     * en funcion del escenario.El programa resta 1 a ambas coordendas(x e y),
     * para tener un valor entre 0 y maximo-1, ya que las dimensiones de los
     * escenarios son Arrays de dos dimensiones, dónde el valor inicial es el
     * 0.Si se introduce una coordenada fuera de los límites del mapa, se debe
     * introducir de nuevo una correcta.
     *
     * @param escenario Escenario de la partida actual
     * @return Coordenada elegida
     */
    public Coordenada elegirCoordenada(Escenario escenario) {
        int x, y;
        int posicionMaxima = escenario.getPosicionMaxima() + 1;

        do {
            x = leerEntero("Introduce la coordenada x: ");
            y = leerEntero("Introduce la coordenada y: ");

            if ((x < 1) || (y < 1) || (x > posicionMaxima) || (y > posicionMaxima)) {
                System.out.println("La posicion elegida esta fuera del mapa: " + posicionMaxima + "x" + posicionMaxima + " Por favor, elija otra coordenada.");
            }
        } while ((x < 1) || (y < 1) || (x > posicionMaxima) || (y > posicionMaxima));

        x = x - 1;
        y = y - 1;

        return new Coordenada(x, y);
    }

    /**
     * Representación de la clase Jugador.
     *
     * @return Cadena que indica el nombre o ID del jugador
     */
    @Override
    public String toString() {
        return "Jugador: " + this.ID;
    }

}
