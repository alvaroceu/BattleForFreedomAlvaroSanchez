package battleForFreedom.gui;

import battleForFreedom.data.DataStore;
import static battleForFreedom.gui.Menu.menuPrincipal;
import battleForFreedom.modelo.escenarios.*;
import battleForFreedom.modelo.partida.Partida;
import static battleForFreedom.utiles.Utiles.leerCadena;
import static battleForFreedom.utiles.Utiles.leerEntero;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class Juego {

    public static void comenzarJuego() {

        ArrayList<Partida> partidasGuardadas;

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
            } else {
                System.out.println("¿Deseas guardar la partida?\n\n"
                        + "1-Si\n"
                        + "2-No\n");
                int guardarOpcion;
                do {
                    guardarOpcion = leerEntero("Introduce tu opcion: ");
                    if ((guardarOpcion < 1) || (guardarOpcion > 2)) {
                        System.out.println("La opcion introducida no existe, repite.");
                    }
                } while ((guardarOpcion < 1) || (guardarOpcion > 2));

                if (guardarOpcion == 1) {
                    partidasGuardadas = (ArrayList<Partida>) DataStore.leerPartida();
                    if (partidasGuardadas != null) {

                        ArrayList<String> partidasEnDisco = new ArrayList();
                        for (Partida partidas : partidasGuardadas) {
                            partidasEnDisco.add(partidas.toString());
                        }

                        if (partidasEnDisco.contains(partida.toString())) {
                            int indice = partidasEnDisco.indexOf(partida.toString());
                            partidasGuardadas.remove(indice);
                        }

                        partidasGuardadas.add(partida);
                    } else {
                        partidasGuardadas = new ArrayList();
                        partidasGuardadas.add(partida);
                    }
                    DataStore.escribirPartida(partidasGuardadas);
                }
            }
        }

        if (opcion == 1) {
            partidasGuardadas = (ArrayList<Partida>) DataStore.leerPartida();
            int indicePartidas = 0;

            for (Partida partidas : partidasGuardadas) {
                indicePartidas++;
                System.out.println(indicePartidas + "-" + partidas);
            }
            int elegirPartida;
            do {
                elegirPartida = leerEntero("Introduce tu opcion: ");
                if ((elegirPartida < 1) || (elegirPartida > indicePartidas)) {
                    System.out.println("La opcion introducida no existe, repite.");
                }
            } while ((elegirPartida < 1) || (elegirPartida > indicePartidas));
            Partida partida = partidasGuardadas.get(elegirPartida - 1);
            menuPrincipal(partida);

            if (partida.getGanador() != null) {
                System.out.println("EL GANADOR ES: " + partida.getGanador());
            } else {
                System.out.println("¿Deseas guardar la partida?\n\n"
                        + "1-Si\n"
                        + "2-No\n");
                int guardarOpcion;
                do {
                    guardarOpcion = leerEntero("Introduce tu opcion: ");
                    if ((guardarOpcion < 1) || (guardarOpcion > 2)) {
                        System.out.println("La opcion introducida no existe, repite.");
                    }
                } while ((guardarOpcion < 1) || (guardarOpcion > 2));

                if (guardarOpcion == 1) {
                    partidasGuardadas = (ArrayList<Partida>) DataStore.leerPartida();
                    if (partidasGuardadas != null) {

                        ArrayList<String> partidasEnDisco = new ArrayList();
                        for (Partida partidas : partidasGuardadas) {
                            partidasEnDisco.add(partidas.toString());
                        }

                        if (partidasEnDisco.contains(partida.toString())) {
                            int indice = partidasEnDisco.indexOf(partida.toString());
                            partidasGuardadas.remove(indice);
                        }

                        partidasGuardadas.add(partida);
                    } else {
                        partidasGuardadas = new ArrayList();
                        partidasGuardadas.add(partida);
                    }
                    DataStore.escribirPartida(partidasGuardadas);
                }
            }

        }

    }

}
