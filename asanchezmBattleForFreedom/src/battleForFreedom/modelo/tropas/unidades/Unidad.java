package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.seres.Ser;

/**
 *
 * @author Alvaro
 */
public abstract class Unidad {

    private int costeUnidad;
    private int energiaAtaque;
    private int energiaDefensa;
    private int energiaMovimiento;
    private int potenciaAtaque;
    private int puntosAnulado;
    private Coordenada posicion;
    private Ser[] seresUnidad;

    /*
    *  Constructor completo, sera utilizado por las clases hijas
     */
    public Unidad(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, Coordenada posicion, int numeroSeres) {
        this.costeUnidad = costeUnidad;
        this.energiaAtaque = energiaAtaque;
        this.energiaDefensa = energiaDefensa;
        this.energiaMovimiento = energiaMovimiento;
        this.potenciaAtaque = potenciaAtaque;
        this.puntosAnulado = puntosAnulado;
        this.posicion = posicion;
        this.seresUnidad = new Ser[numeroSeres];
    }

}
