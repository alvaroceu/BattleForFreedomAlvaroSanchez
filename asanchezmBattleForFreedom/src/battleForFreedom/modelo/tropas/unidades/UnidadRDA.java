package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.modelo.funcionamiento.Raza;
import battleForFreedom.modelo.propio.Jugador;

/**
 *
 * @author Alvaro
 */
public abstract class UnidadRDA extends Unidad {

    public UnidadRDA(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, int numeroSeres, int gastoEnergia, Jugador jugador) {
        super(costeUnidad, energiaAtaque, energiaDefensa, energiaMovimiento, potenciaAtaque, puntosAnulado, gastoEnergia, Raza.HUMANO, numeroSeres, jugador);
    }

}
