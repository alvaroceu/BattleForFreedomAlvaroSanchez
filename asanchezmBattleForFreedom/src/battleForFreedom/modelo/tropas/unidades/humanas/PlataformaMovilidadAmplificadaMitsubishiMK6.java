package battleForFreedom.modelo.tropas.unidades.humanas;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.propio.Jugador;
import battleForFreedom.modelo.tropas.unidades.UnidadRDA;

/**
 *
 * @author Alvaro
 */
public class PlataformaMovilidadAmplificadaMitsubishiMK6 extends UnidadRDA {

    public PlataformaMovilidadAmplificadaMitsubishiMK6(Jugador jugador) {
        super(500, 1000, 0, 500, 20, 250, 1, 25, jugador);
    }

    /**
     * Este método determina si una coordenada dada se encuentra dentro del
     * rango de ataque de la unidad de clase Plataforma de Movilidad Amplificada
     * Mitsubishi MK-6.
     *
     * @param coordenada Coordenada dada
     * @return True si esta dentro de rango, false si no lo está
     */
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        return this.comprobarRangoAtaque(coordenada, 1);
    }

    /**
     * Representación de Plataforma de Movilidad Amplificada Mitsubishi MK-6
     */
    @Override
    public String toString() {
        return "Plataforma de Movilidad Amplificada Mitsubishi MK-6" + super.toString();
    }

    /**
     * Este método genera una coordenada dentro del rango de movimiento de la
     * unidad de clase PlataformaMovilidadAmplificadaMitsubishiMK6.
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
        return "Plataforma de Movilidad Amplificada Mitsubishi MK-6";
    }
}
