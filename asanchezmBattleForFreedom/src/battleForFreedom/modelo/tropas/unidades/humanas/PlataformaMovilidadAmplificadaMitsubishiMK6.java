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

    //Falta por implementar
    @Override
    public Boolean enRangoAtaque(Coordenada coordenada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
