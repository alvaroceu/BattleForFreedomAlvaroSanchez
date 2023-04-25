package battleForFreedom.modelo.tropas.unidades.humanas;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadRDA;

/**
 *
 * @author Alvaro
 */
public class AT99Escorpion extends UnidadRDA {

    public AT99Escorpion(Coordenada posicion) {
        super(15000, 7500, 7500, 5000, 500, 10000, posicion, 4);
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
        return this.comprobarRango(coordenada, 10);
    }

    /**
     * Representación de AT-99 Escorpion
     */
    @Override
    public String toString() {
        return "AT-99 Escorpion";
    }
}
