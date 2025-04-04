package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class TitanothereCabezamartillo extends UnidadNavi {

    public TitanothereCabezamartillo(Jugador jugador) {
        super(1000, 11000, 11000, 4500, 300, 250, 1, 25, jugador);
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
        return "Titanothere Cabezamartillo" + super.toString();
    }

    /**
     * Este método genera una coordenada dentro del rango de movimiento de la
     * unidad de clase Titanothere Cabezamartillo.
     *
     * @return Coordenada en cuestion
     */
    @Override
    public Coordenada establecerCoordenadaMovimiento() {
        return super.generarCoordenadaMovimiento(2);
    }

    /**
     * Método similar a toString que tan solo devuelve el nombre de la unidad
     *
     * @return
     */
    public String tipoUnidad() {
        return "Titanothere Cabezamartillo";
    }
}
