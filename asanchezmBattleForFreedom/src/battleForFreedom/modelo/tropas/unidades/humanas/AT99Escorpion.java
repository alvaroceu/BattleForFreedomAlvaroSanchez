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

    //Falta por implementar
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
