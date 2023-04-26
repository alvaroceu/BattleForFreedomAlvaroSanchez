package battleForFreedom.modelo.tropas.unidades.humanas;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadRDA;

/**
 *
 * @author Alvaro
 */
public class PlataformaMovilidadAmplificadaMitsubishiMK6 extends UnidadRDA {

    public PlataformaMovilidadAmplificadaMitsubishiMK6(Coordenada posicion) {
        super(500, 1000, 0, 500, 20, 250, posicion, 1);
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
        return "Plataforma de Movilidad Amplificada Mitsubishi MK-6";
    }
}
