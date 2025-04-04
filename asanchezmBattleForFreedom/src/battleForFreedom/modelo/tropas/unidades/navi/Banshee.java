package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class Banshee extends UnidadNavi {

    public Banshee(Jugador jugador) {
        super(2000, 8000, 3500, 3500, 300, 1000, 2, 10, jugador);
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
        return "Banshee de Montaña" + super.toString();
    }

    /**
     * Este método siempre devuelve null ya que la banshee de montaña no tiene
     * limite de movimiento y por lo tanto no es necesario establecer una
     * posición desde esta clase, y se podrá hacer desde la clase padre.
     *
     * @return null
     */
    @Override
    public Coordenada establecerCoordenadaMovimiento() {
        return null;
    }

    /**
     * Método similar a toString que tan solo devuelve el nombre de la unidad
     *
     * @return
     */
    public String tipoUnidad() {
        return "Banshee";
    }
}
