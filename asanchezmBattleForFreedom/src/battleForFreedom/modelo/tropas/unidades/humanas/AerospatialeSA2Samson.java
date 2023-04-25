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

    //Falta por implementar
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
