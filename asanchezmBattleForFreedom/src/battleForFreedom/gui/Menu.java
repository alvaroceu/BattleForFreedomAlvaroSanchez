package battleForFreedom.gui;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.excepciones.CasillaOcupadaException;
import battleForFreedom.excepciones.EnergiaMovimientoException;
import battleForFreedom.excepciones.FueraMapaException;
import battleForFreedom.excepciones.PuntosInsuficientesException;
import battleForFreedom.excepciones.UnidadIncompletaException;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.partida.Partida;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.seres.humano.Artillero;
import battleForFreedom.modelo.tropas.seres.humano.ComandanteDeSecOps;
import battleForFreedom.modelo.tropas.seres.navi.Omaticaya;
import battleForFreedom.modelo.tropas.seres.navi.Tipani;
import battleForFreedom.modelo.tropas.unidades.Unidad;
import battleForFreedom.modelo.tropas.unidades.humanas.AT99Escorpion;
import battleForFreedom.modelo.tropas.unidades.humanas.AerospatialeSA2Samson;
import battleForFreedom.modelo.tropas.unidades.humanas.PlataformaMovilidadAmplificadaMitsubishiMK6;
import battleForFreedom.modelo.tropas.unidades.navi.Banshee;
import battleForFreedom.modelo.tropas.unidades.navi.Thanator;
import battleForFreedom.modelo.tropas.unidades.navi.TitanothereCabezamartillo;
import static battleForFreedom.utiles.Utiles.leerEntero;

/**
 *
 * @author Alvaro
 */
public class Menu {

    public static void menuPrincipal(Partida partida) {

        Boolean jugadoresPreparados = false;
        Boolean salirDeJuego;

        do {
            salirDeJuego = false;
            System.out.println("\nTurno:" + partida.getTurno() + "\n------TURNO DE: " + partida.getJugadorActual() + "------\n"
                    + "¿Qué deseas hacer?\n\n"
                    + "1-Atacar\n"
                    + "2-Mover una unidad\n"
                    + "3-Comprar\n"
                    + "4-Salir del juego\n\n");

            int opcion;
            int unidadesPreparadas;
            do {
                do {
                    opcion = leerEntero("Escoje tu opcion: ");
                    if ((opcion < 1) || (opcion > 4)) {
                        System.out.println("La opcion escogida no existe, repite\n");
                    }
                } while ((opcion < 1) || (opcion > 4));

                unidadesPreparadas = 0;
                for (Unidad unidad : partida.getJugadorActual().getEjercito()) {
                    if (unidad.unidadCompleta()) {
                        unidadesPreparadas++;
                    }
                }

                if (((opcion == 1) || (opcion == 2)) && (unidadesPreparadas == 0)) {
                    System.out.println("Aun no tienes unidades preparadas, debes comprar");
                }
            } while (((opcion == 1) || (opcion == 2)) && (unidadesPreparadas == 0));

            switch (opcion) {
                case 1:
                    menuAtaque(partida.getJugadorActual(), partida.getEscenario(), partida.getJugadorNoActual());
                    break;
                case 2:
                    menuMover(partida.getJugadorActual(), partida.getEscenario(), partida.getJugadorNoActual());
                    break;
                case 3:
                    menuComprar(partida);
                    break;
                case 4:
                    salirDeJuego = true;
                    break;
            }

            int eleccion = 3;
            do {

                System.out.println("\nQuieres ver el centro de mandos antes de pasar turno?\n\n"
                        + "1-Si, ver mi equipo\n"
                        + "2-Si, ver los mensajes de la partida\n"
                        + "3-No\n");

                do {
                    eleccion = leerEntero("Escoje tu opcion: ");
                    if ((opcion < 1) || (opcion > 3)) {
                        System.out.println("La opcion escogida no existe, repite\n");
                    }
                } while ((eleccion < 1) || (eleccion > 3));

                if (eleccion == 1) {
                    System.out.println(partida.getJugadorActual().getEquipoCentroMandos());
                }
                if (eleccion == 2) {
                    System.out.println(partida.getJugadorActual().getMensajesCentroMandos());
                }

            } while (eleccion != 3);

            if (jugadoresPreparados == false) {
                if ((partida.getJugadorHumano().getEjercito().isEmpty()) || (partida.getJugadorNavi().getEjercito().isEmpty())) {
                } else {
                    jugadoresPreparados = true;
                }
            } else {
                partida.setGanador();
            }

            if (!salirDeJuego) {
                partida.pasarTurno();
            }

        } while ((partida.getGanador() == null) && (!salirDeJuego));
    }

    private static void menuAtaque(Jugador jugador, Escenario escenario, Jugador rival) {

        System.out.println("Has escogido atacar. ¿Que unidad va a atacar?\n\n");

        int indiceUnidad = 1;
        for (Unidad unidad : jugador.getEjercito()) {
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
        for (Unidad unidad : jugador.getEjercito()) {
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
                jugador.realizarAtaque(escenario, coordenada, unidadAtacante, rival);
                repetir = false;
            } catch (AtaqueException ex) {
                System.out.println(ex);
                if ("Fuera de rango".equals(ex.getMotivo())) {
                    System.out.println("Debe escoger una coordenada valida para el ataque");
                    repetir = true;
                }
            } catch (UnidadIncompletaException ex) {
                //Debido a la implementacion de este método, nunca saltará esta excepción
            } catch (FueraMapaException ex) {
                System.out.println("La coordenada estaba fuera del mapa. Debe escoger otra");
                repetir = true;
            }
        } while (repetir);

    }

    private static void menuMover(Jugador jugador, Escenario escenario, Jugador rival) {

        System.out.println("Has escogido mover. ¿Que unidad se movera?\n\n");

        int indiceUnidad = 1;
        for (Unidad unidad : jugador.getEjercito()) {
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

        Unidad unidadMovida = null;
        int indiceUnidad2 = 1;
        for (Unidad unidad : jugador.getEjercito()) {
            if (indiceUnidad2 == unidadEscogida) {
                unidadMovida = unidad;
            }
            if (unidad.unidadCompleta()) {
                indiceUnidad2++;
            }
        }

        Boolean repetir = false;
        do {
            try {
                jugador.moverUnidad(escenario, unidadMovida, rival);
                repetir = false;
            } catch (EnergiaMovimientoException ex) {
                if (ex.quedaEnergia()) {
                    repetir = true;
                }
            } catch (CasillaOcupadaException ex) {
                repetir = true;
            } catch (UnidadIncompletaException ex) {
                //Debido a la implementacion de este método, nunca saltará esta excepción
            } catch (FueraMapaException ex) {
                repetir = true;
            }
        } while (repetir);

    }

    private static void menuComprar(Partida partida) {

        Boolean salir = false;

        do {

            if (partida.getJugadorActual() == partida.getJugadorHumano()) {
                System.out.println("¿Que deseas comprar?\n\n"
                        + "1-Unidades\n"
                        + "2-Seres\n");

                int opcion;
                do {
                    opcion = leerEntero("Introduce tu opcion: ");
                    if ((opcion < 1) || (opcion > 2)) {
                        System.out.println("La opcion escogida no existe, repite\n");
                    }
                } while ((opcion < 1) || (opcion > 2));

                if (opcion == 1) {

                    System.out.println("¿Que unidad deseas comprar?\n"
                            + "Tu dinero: " + partida.getJugadorActual().getPuntos() + "\n\n"
                            + "1-AT99 Escorpion (15000)\n"
                            + "2-Aerospatiale SA2 Samson (2500)\n"
                            + "3-Plataforma de Movilidad Ampl. Mitsubishi MK6 (500)\n");

                    int unidadAComprar;
                    do {
                        unidadAComprar = leerEntero("Introduce tu opcion: ");
                        if ((unidadAComprar < 1) || (unidadAComprar > 3)) {
                            System.out.println("La opcion escogida no existe, repite\n");
                        }
                    } while ((unidadAComprar < 1) || (unidadAComprar > 3));

                    try {
                        if (unidadAComprar == 1) {
                            partida.getJugadorActual().comprarUnidad(new AT99Escorpion(partida.getJugadorActual()), partida.getEscenario());
                        } else if (unidadAComprar == 2) {
                            partida.getJugadorActual().comprarUnidad(new AerospatialeSA2Samson(partida.getJugadorActual()), partida.getEscenario());
                        } else if (unidadAComprar == 3) {
                            partida.getJugadorActual().comprarUnidad(new PlataformaMovilidadAmplificadaMitsubishiMK6(partida.getJugadorActual()), partida.getEscenario());
                        }
                    } catch (PuntosInsuficientesException ex) {
                        System.out.println("No tienes dinero suficiente para comprar esa unidad");
                    }
                }

                ///////// SEPARACION DE COMPRA DE UNIDADES - SERES //////////////
                if (opcion == 2) {

                    int indiceUnidad = 1;
                    System.out.println("¿Sobre que unidad quieres los seres?");
                    for (Unidad unidad : partida.getJugadorActual().getEjercito()) {
                        if (!unidad.unidadCompleta()) {
                            System.out.println(indiceUnidad + "-" + unidad);
                            indiceUnidad++;
                        }
                    }
                    System.out.println("\n");

                    if (indiceUnidad == 1) {
                        System.out.println("No tienes unidades vacias sobre las que comprar seres");
                    } else {
                        int unidadEscogida;
                        do {
                            unidadEscogida = leerEntero("Introduce tu opcion: ");
                            if ((unidadEscogida < 1) || (unidadEscogida > (indiceUnidad - 1))) {
                                System.out.println("La opcion escogida no existe, repite\n");
                            }
                        } while ((unidadEscogida < 1) || (unidadEscogida > (indiceUnidad - 1)));

                        Unidad unidadBajoSer = null;
                        int indiceUnidad2 = 1;
                        for (Unidad unidad : partida.getJugadorActual().getEjercito()) {
                            if (indiceUnidad2 == unidadEscogida) {
                                unidadBajoSer = unidad;
                            }
                            if (!unidad.unidadCompleta()) {
                                indiceUnidad2++;
                            }
                        }

                        ///////////////// HASTA AQUI SE HA ELEGIDO LA UNIDAD////////////////////
                        System.out.println("¿Que ser deseas comprar?\n"
                                + "Tu dinero: " + partida.getJugadorActual().getPuntos() + "\n\n"
                                + "1-Artillero (50)\n"
                                + "2-Comandante de SecOps (100)\n");

                        int serAComprar;
                        do {
                            serAComprar = leerEntero("Introduce tu opcion: ");
                            if ((serAComprar < 1) || (serAComprar > 2)) {
                                System.out.println("La opcion escogida no existe, repite\n");
                            }
                        } while ((serAComprar < 1) || (serAComprar > 2));

                        try {
                            if (serAComprar == 1) {
                                partida.getJugadorActual().comprarSer(unidadBajoSer, new Artillero(), partida.getEscenario());
                            } else if (serAComprar == 2) {
                                partida.getJugadorActual().comprarSer(unidadBajoSer, new ComandanteDeSecOps(), partida.getEscenario());
                            }
                        } catch (PuntosInsuficientesException ex) {
                            System.out.println("No tienes dinero suficiente para comprar ese ser");
                        }
                    }

                }
            }

            //////////////////////////////////////////////////////////////////////////
            ////////////////////// AHORA SI JUGADOR ES NAVI //////////////////////////
            //////////////////////////////////////////////////////////////////////////
            if (partida.getJugadorActual() == partida.getJugadorNavi()) {
                System.out.println("¿Que deseas comprar?\n\n"
                        + "1-Unidades\n"
                        + "2-Seres\n");

                int opcion;
                do {
                    opcion = leerEntero("Introduce tu opcion: ");
                    if ((opcion < 1) || (opcion > 2)) {
                        System.out.println("La opcion escogida no existe, repite\n");
                    }
                } while ((opcion < 1) || (opcion > 2));

                if (opcion == 1) {

                    System.out.println("¿Que unidad deseas comprar?\n"
                            + "Tu dinero: " + partida.getJugadorActual().getPuntos() + "\n\n"
                            + "1-Banshee de Montaña (2000)\n"
                            + "2-Thanator (8000)\n"
                            + "3-Titanothere Cabezamartillo (1000)\n");

                    int unidadAComprar;
                    do {
                        unidadAComprar = leerEntero("Introduce tu opcion: ");
                        if ((unidadAComprar < 1) || (unidadAComprar > 3)) {
                            System.out.println("La opcion escogida no existe, repite\n");
                        }
                    } while ((unidadAComprar < 1) || (unidadAComprar > 3));

                    try {
                        if (unidadAComprar == 1) {
                            partida.getJugadorActual().comprarUnidad(new Banshee(partida.getJugadorActual()), partida.getEscenario());
                        } else if (unidadAComprar == 2) {
                            partida.getJugadorActual().comprarUnidad(new Thanator(partida.getJugadorActual()), partida.getEscenario());
                        } else if (unidadAComprar == 3) {
                            partida.getJugadorActual().comprarUnidad(new TitanothereCabezamartillo(partida.getJugadorActual()), partida.getEscenario());
                        }
                    } catch (PuntosInsuficientesException ex) {
                        System.out.println("No tienes dinero suficiente para comprar esa unidad");
                    }
                }

                ///////// SEPARACION DE COMPRA DE UNIDADES - SERES //////////////
                if (opcion == 2) {

                    int indiceUnidad = 1;
                    for (Unidad unidad : partida.getJugadorActual().getEjercito()) {
                        if (!unidad.unidadCompleta()) {
                            System.out.println(indiceUnidad + "-" + unidad);
                            indiceUnidad++;
                        }
                    }
                    System.out.println("\n");

                    if (indiceUnidad == 1) {
                        System.out.println("No tienes unidades vacias sobre las que comprar seres");
                    } else {
                        int unidadEscogida;
                        do {
                            unidadEscogida = leerEntero("Introduce tu opcion: ");
                            if ((unidadEscogida < 1) || (unidadEscogida > (indiceUnidad - 1))) {
                                System.out.println("La opcion escogida no existe, repite\n");
                            }
                        } while ((unidadEscogida < 1) || (unidadEscogida > (indiceUnidad - 1)));

                        Unidad unidadBajoSer = null;
                        int indiceUnidad2 = 1;
                        for (Unidad unidad : partida.getJugadorActual().getEjercito()) {
                            if (indiceUnidad2 == unidadEscogida) {
                                unidadBajoSer = unidad;
                            }
                            if (!unidad.unidadCompleta()) {
                                indiceUnidad2++;
                            }
                        }

                        ///////////////// HASTA AQUI SE HA ELEGIDO LA UNIDAD////////////////////
                        System.out.println("¿Que ser deseas comprar?\n"
                                + "Tu dinero: " + partida.getJugadorActual().getPuntos() + "\n\n"
                                + "1-Omaticaya (100)\n"
                                + "2-Tipani (50)\n");

                        int serAComprar;
                        do {
                            serAComprar = leerEntero("Introduce tu opcion: ");
                            if ((serAComprar < 1) || (serAComprar > 2)) {
                                System.out.println("La opcion escogida no existe, repite\n");
                            }
                        } while ((serAComprar < 1) || (serAComprar > 2));

                        try {
                            if (serAComprar == 1) {
                                partida.getJugadorActual().comprarSer(unidadBajoSer, new Omaticaya(), partida.getEscenario());
                            } else if (serAComprar == 2) {
                                partida.getJugadorActual().comprarSer(unidadBajoSer, new Tipani(), partida.getEscenario());
                            }
                        } catch (PuntosInsuficientesException ex) {
                            System.out.println("No tienes dinero suficiente para comprar ese ser");
                        }
                    }

                }
            }

            int opcionSalir;
            System.out.println("\n\n¿Que deseas?\n\n"
                    + "1-Seguir comprando\n"
                    + "2-Salir\n");

            do {
                opcionSalir = leerEntero("Introduce tu opcion: ");
                if ((opcionSalir < 1) || (opcionSalir > 2)) {
                    System.out.println("La opcion escogida no existe, repite\n");
                }
            } while ((opcionSalir < 1) || (opcionSalir > 2));

            if (opcionSalir == 2) {
                salir = true;
            }

        } while (!salir);
    }

}
