package battleForFreedom.modelo.tropas.unidades.navi;

import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.unidades.UnidadNavi;

/**
 *
 * @author Alvaro
 */
public class Thanator extends UnidadNavi {

    public Thanator(Coordenada posicion) {
        super(8000, 9000, 9000, 6000, 600, 4000, posicion, 3);
    }

    //Falta por implementar
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
