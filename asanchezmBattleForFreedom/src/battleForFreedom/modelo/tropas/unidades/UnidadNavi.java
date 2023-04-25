package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.funcionamiento.Raza;

/**
 *
 * @author Alvaro
 */
public abstract class UnidadNavi extends Unidad {

    private Raza raza;

    public UnidadNavi(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, Coordenada posicion, int numeroSeres) {
        super(costeUnidad, energiaAtaque, energiaDefensa, energiaMovimiento, potenciaAtaque, puntosAnulado, posicion, numeroSeres);
        this.raza = Raza.NAVI;
    }

}
