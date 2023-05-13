package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.modelo.funcionamiento.Raza;

/**
 *
 * @author Alvaro
 */
public abstract class UnidadNavi extends Unidad {

    public UnidadNavi(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, int numeroSeres, int gastoEnergia) {
        super(costeUnidad, energiaAtaque, energiaDefensa, energiaMovimiento, potenciaAtaque, puntosAnulado, gastoEnergia, Raza.NAVI, numeroSeres);
    }
}
