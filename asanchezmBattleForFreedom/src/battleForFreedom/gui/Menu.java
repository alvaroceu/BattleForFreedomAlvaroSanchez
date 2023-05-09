package battleForFreedom.gui;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.excepciones.UnidadIncompletaException;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.partida.Partida;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.unidades.Unidad;
import static battleForFreedom.utiles.Utiles.leerEntero;

/**
 *
 * @author Alvaro
 */
public class Menu {

    public static void menuPrincipal(Partida partida) {

        do {
            System.out.println("Turno de jugador: " + partida.getJugadorActual() + "\n"
                    + "¿Qué deseas hacer?\n\n"
                    + "1-Atacar\n"
                    + "2-Mover una unidad\n"
                    + "3-Comprar\n\n");

            int opcion;
            int unidadesPreparadas;
            do {
                do {
                    opcion = leerEntero("Escoje tu opcion: ");
                    if ((opcion < 1) || (opcion > 3)) {
                        System.out.println("La opcion escogida no existe, repite\n");
                    }
                } while ((opcion < 1) || (opcion > 3));

                unidadesPreparadas = 0;
                for (Unidad unidad : partida.getJugadorActual().getUnidadesJugador()) {
                    if (unidad.unidadCompleta()) {
                        unidadesPreparadas++;
                    }
                }

                if (((opcion == 1) || (opcion == 2)) && (unidadesPreparadas == 0)) {
                    System.out.println("Aun no tienes unidades preparadas, debes comprar");
                }
            } while ((opcion == 1) && (unidadesPreparadas == 0));

            switch (opcion) {
                //Falta por implementar los métodos:
                case 1:
                    menuAtaque(partida.getJugadorActual(), partida.getEscenario());
                case 2:
                    menuMover();
                case 3:
                    menuComprar();
            }

            partida.pasarTurno();
        } while (partida.getGanador() == null);
    }

    private static void menuAtaque(Jugador jugador, Escenario escenario) {

        System.out.println("Has escogido atacar. ¿Qué unidad atacará?\n\n");

        int indiceUnidad = 1;
        for (Unidad unidad : jugador.getUnidadesJugador()) {
            if (unidad.unidadCompleta()) {
                System.out.println(indiceUnidad + "-" + unidad);
                indiceUnidad++;
            }
        }
        System.out.println("\n");

        int unidadEscogida;
        do {
            unidadEscogida = leerEntero("Introduce tu opcion: ");
            if ((unidadEscogida < 1) || (unidadEscogida > (indiceUnidad - 1))) {
                System.out.println("La opcion escogida no existe, repite\n");
            }
        } while ((unidadEscogida < 1) || (unidadEscogida > (indiceUnidad - 1)));

        Unidad unidadAtacante = null;
        int indiceUnidad2 = 1;
        for (Unidad unidad : jugador.getUnidadesJugador()) {
            if (unidad.unidadCompleta()) {
                indiceUnidad2++;
            }
            if (indiceUnidad2 == indiceUnidad) {
                unidadAtacante = unidad;
            }
        }

        Boolean repetir = false;
        do {

            System.out.println("Unidad que atacara: " + unidadAtacante + "\n");
            int x = leerEntero("Elija la coordenada x del ataque: ");
            int y = leerEntero("Elija la coordenada y del ataque: ");
            Coordenada coordenada = new Coordenada(x, y);

            try {
                jugador.realizarAtaque(escenario, coordenada, unidadAtacante);
                repetir = false;
            } catch (AtaqueException ex) {
                System.out.println(ex);
                if ("Fuera de rango".equals(ex.getMotivo())) {
                    System.out.println("Debe escoger una coordenada válida para el ataque");
                    repetir = true;
                }
            } catch (UnidadIncompletaException ex) {
                //Debido a la implementacion de este método, nunca saltará esta excepción
            }
        } while (repetir);

    }

}
