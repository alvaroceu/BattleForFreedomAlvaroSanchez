package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class BansheeDeMontaña extends UnidadNavi {

    public BansheeDeMontaña(Coordenada posicion) {
        super(2000, 8000, 3500, 3500, 300, 1000, posicion, 2, 10);
    }

    /**
     * Este método determina si una coordenada dada se encuentra dentro del
     * rango de ataque de la unidad de clase Banshee de Montaña.
     *
     * @param coordenada Coordenada dada
     * @return True si esta dentro de rango, false si no lo está
     */
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        return this.comprobarRangoAtaque(coordenada, 3);
    }

    /**
     * Representación de Banshee de Montaña
     */
    @Override
    public String toString() {
        return "Banshee de Montaña";
    }

    /**
     * El método enRangoMovimiento de una Banshee de Montaña siempre devuelve
     * true, ya que no tiene limitación de movimiento de casillas, tan solo de
     * energía
     *
     * @param coordenada Coordenada dada
     * @return True siempre
     */
    @Override
    public Boolean enRangoMovimiento(Coordenada coordenada) {
        return true;
    }
}
