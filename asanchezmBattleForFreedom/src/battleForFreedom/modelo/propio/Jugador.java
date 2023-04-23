package battleForFreedom.modelo.propio;

/**
 *
 * @author Alvaro
 */
public class Jugador {

    private String ID;
    private Equipo equipo;

    /*
    *  Constructor que recibe como parametro el nombre
    *  o ID del jugador
     */
    public Jugador(String Id, Equipo equipo) {
        this.ID = Id;
        this.equipo = equipo;
    }

}
