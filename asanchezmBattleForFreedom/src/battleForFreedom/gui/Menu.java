package battleForFreedom.gui;

import battleForFreedom.modelo.partida.Partida;
import static battleForFreedom.utiles.Utiles.leerEntero;

/**
 *
 * @author Alvaro
 */
public class Menu {

    public static void menuPrincipal(Partida partida) {

        System.out.println("Turno de jugador: " + partida.getJugadorActual() + "\n"
                + "¿Qué deseas hacer?\n\n"
                + "1-Atacar\n"
                + "2-Mover una unidad\n"
                + "3-Comprar\n\n");

        int opcion;
        do {
            opcion = leerEntero("Escoje tu opcion: ");
            if ((opcion < 1) || (opcion > 3)) {
                System.out.println("La opcion escogida no existe, repite\n");
            }
        } while ((opcion < 1) || (opcion > 3));

        switch (opcion) {
            //Falta por implementar los métodos:
            case 1:
                menuAtaque();
            case 2:
                menuMover();
            case 3:
                menuComprar();
        }

    }

}
