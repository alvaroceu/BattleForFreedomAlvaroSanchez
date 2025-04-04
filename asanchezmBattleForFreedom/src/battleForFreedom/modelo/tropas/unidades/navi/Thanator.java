package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class Thanator extends UnidadNavi {

    public Thanator(Jugador jugador) {
        super(8000, 9000, 9000, 6000, 600, 4000, 3, 10, jugador);
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
        return "Thanator" + super.toString();
    }

    /**
     * Este método genera una coordenada dentro del rango de movimiento de la
     * unidad de clase Thanator.
     *
     * @return Coordenada en cuestion
     */
    @Override
    public Coordenada establecerCoordenadaMovimiento() {
        return super.generarCoordenadaMovimiento(50);
    }

    /**
     * Método similar a toString que tan solo devuelve el nombre de la unidad
     *
     * @return
     */
    public String tipoUnidad() {
        return "Thanator";
    }
}
