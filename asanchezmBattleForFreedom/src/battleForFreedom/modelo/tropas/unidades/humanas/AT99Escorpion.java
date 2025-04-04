package battleForFreedom.modelo.tropas.unidades.humanas;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.unidades.UnidadRDA;

/**
 *
 * @author Alvaro
 */
public class AT99Escorpion extends UnidadRDA {

    public AT99Escorpion(Jugador jugador) {
        super(15000, 7500, 7500, 5000, 500, 10000, 4, 100, jugador);
    }

    /**
     * Este método determina si una coordenada dada se encuentra dentro del
     * rango de ataque de la unidad de clase AT-99 Escorpion.
     *
     * @param coordenada Coordenada dada
     * @return True si esta dentro de rango, false si no lo está
     */
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        return this.comprobarRangoAtaque(coordenada, 10);
    }

    /**
     * Representación de AT-99 Escorpion
     */
    @Override
    public String toString() {
        return "AT-99 Escorpion" + super.toString();
    }

    /**
     * Este método genera una coordenada dentro del rango de movimiento de la
     * unidad de clase PlataformaMovilidadAmplificadaMitsubishiMK6.
     *
     * @return Coordenada en cuestion
     */
    @Override
    public Coordenada establecerCoordenadaMovimiento() {
        return super.generarCoordenadaMovimiento(20);
    }

    /**
     * Método similar a toString que tan solo devuelve el nombre de la unidad
     *
     * @return
     */
    public String tipoUnidad() {
        return "AT-99 Escorpion";
    }
}
