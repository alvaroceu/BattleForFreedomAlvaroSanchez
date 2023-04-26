package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class TitanothereCabezamartillo extends UnidadNavi {

    public TitanothereCabezamartillo(Coordenada posicion) {
        super(1000, 11000, 11000, 4500, 300, 250, posicion, 1, 25);
    }

    /**
     * Este método determina si una coordenada dada se encuentra dentro del
     * rango de ataque de la unidad de clase Titanothere Cabezamartillo.
     *
     * @param coordenada Coordenada dada
     * @return True si esta dentro de rango, false si no lo está
     */
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        return this.comprobarRangoAtaque(coordenada, 1);
    }

    /**
     * Representación de Titanothere Cabezamartillo
     */
    @Override
    public String toString() {
        return "Titanothere Cabezamartillo";
    }

    /**
     * Este método determina si una coordenada dada se encuentra dentro del
     * rango de movimiento de la unidad de clase Titanothere Cabezamartillo.
     *
     * @param coordenada Coordenada dada
     * @return True si esta dentro de rango, false si no lo está
     */
    @Override
    public Boolean enRangoMovimiento(Coordenada coordenada) {
        return super.comprobarRangoMovimiento(coordenada, 2);
    }
}
