package battleForFreedom.modelo.tropas.unidades.humanas;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadRDA;

/**
 *
 * @author Alvaro
 */
public class AerospatialeSA2Samson extends UnidadRDA {

    public AerospatialeSA2Samson(Coordenada posicion) {
        super(2500, 1000, 1000, 500, 80, 1500, posicion, 2);
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
        return "Aerospatiale SA-2 Samson";
    }
}
