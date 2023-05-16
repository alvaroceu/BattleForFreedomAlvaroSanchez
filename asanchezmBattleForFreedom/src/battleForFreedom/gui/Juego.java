package battleForFreedom.gui;

import static battleForFreedom.gui.Menu.menuPrincipal;
import battleForFreedom.modelo.escenarios.*;
import battleForFreedom.modelo.partida.Partida;
import static battleForFreedom.utiles.Utiles.leerCadena;
import static battleForFreedom.utiles.Utiles.leerEntero;

/**
 *
 * @author Alvaro
 */
public class Juego {

    public static void comenzarJuego() {

        int opcion;
        do {
            System.out.println("¿Quieres buscar partidas guardadas?\n\n"
                    + "1-Si\n"
                    + "2-No, crear nueva\n");
            opcion = leerEntero("Escoge tu opcion: ");
        } while ((opcion < 1) || (opcion > 2));

        if (opcion == 2) {
            System.out.println("¿En que escenario deseas jugar?\n\n"
                    + "1-Arbol de las Almas (100x100)\n"
                    + "2-Jardines Colgantes (200x200)\n"
                    + "3-Arbol Madre (300x300)\n");
            int opcionEscenario;
            do {
                opcionEscenario = leerEntero("Introduce tu opcion: ");
                if ((opcionEscenario < 1) || (opcionEscenario > 3)) {
                    System.out.println("La opcion introducida no existe, repite.");
                }
            } while ((opcionEscenario < 1) || (opcionEscenario > 3));

            Escenario escenario;
            if (opcionEscenario == 1) {
                escenario = new ArbolDeLasAlmas();
            } else if (opcionEscenario == 2) {
                escenario = new JardinesColgantes();
            } else {
                escenario = new ArbolMadre();
            }

            Partida partida = new Partida(escenario, leerCadena("Introduce el nombre del jugador Humano: "), leerCadena("Introduce el nombre del jugador Navi: "));
            menuPrincipal(partida);

            if (partida.getGanador() != null) {
                System.out.println("EL GANADOR ES: " + partida.getGanador());
            }
        }

        if (opcion == 1) {

        }

    }

}
