package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.funcionamiento.Raza;

/**
 *
 * @author Alvaro
 */
public abstract class UnidadRDA extends Unidad {

    public UnidadRDA(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, Coordenada posicion, int numeroSeres, int gastoEnergia) {
        super(costeUnidad, energiaAtaque, energiaDefensa, energiaMovimiento, potenciaAtaque, puntosAnulado, posicion, numeroSeres, gastoEnergia, Raza.HUMANO);
    }

}
