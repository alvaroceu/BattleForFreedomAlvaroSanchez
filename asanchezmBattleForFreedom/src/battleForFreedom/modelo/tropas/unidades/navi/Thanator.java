package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class Thanator extends UnidadNavi {

    public Thanator(Coordenada posicion) {
        super(8000, 9000, 9000, 6000, 600, 4000, posicion, 3);
    }

    /**
     * Este método determina si una coordenada dada se encuentra dentro del
     * rango de ataque de la unidad de clase Thanator.
     *
     * @param coordenada Coordenada dada
     * @return True si esta dentro de rango, false si no lo está
     */
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        return this.comprobarRangoAtaque(coordenada, 5);
    }

    /**
     * Representación de Thanator
     */
    @Override
    public String toString() {
        return "Thanator";
    }
}
