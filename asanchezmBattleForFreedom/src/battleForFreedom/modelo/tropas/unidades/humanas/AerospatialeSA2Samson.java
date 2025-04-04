package battleForFreedom.modelo.tropas.unidades.humanas;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.unidades.UnidadRDA;

/**
 *
 * @author Alvaro
 */
public class AerospatialeSA2Samson extends UnidadRDA {

    public AerospatialeSA2Samson(Jugador jugador) {
        super(2500, 1000, 1000, 500, 80, 1500, 2, 50, jugador);
    }

    /**
     * Este método determina si una coordenada dada se encuentra dentro del
     * rango de ataque de la unidad de clase Aerospatiale SA-2 Samson.
     *
     * @param coordenada Coordenada dada
     * @return True si esta dentro de rango, false si no lo está
     */
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        return this.comprobarRangoAtaque(coordenada, 5);
    }

    /**
     * Representación de Aerospatiale SA-2 Samson
     */
    @Override
    public String toString() {
        return "Aerospatiale SA-2 Samson" + super.toString();
    }

    /**
     * Este método genera una coordenada dentro del rango de movimiento de la
     * unidad de clase PlataformaMovilidadAmplificadaMitsubishiMK6.
     *
     * @return Coordenada en cuestion
     */
    @Override
    public Coordenada establecerCoordenadaMovimiento() {
        return super.generarCoordenadaMovimiento(10);
    }

    /**
     * Método similar a toString que tan solo devuelve el nombre de la unidad
     *
     * @return
     */
    public String tipoUnidad() {
        return "Aerospatiale SA-2 Samson";
    }
}
