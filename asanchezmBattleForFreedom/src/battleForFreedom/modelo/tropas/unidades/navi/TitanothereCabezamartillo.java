package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class TitanothereCabezamartillo extends UnidadNavi {

    public TitanothereCabezamartillo(Coordenada posicion) {
        super(1000, 11000, 11000, 4500, 300, 250, posicion, 1);
    }

    //Falta por implementar
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
