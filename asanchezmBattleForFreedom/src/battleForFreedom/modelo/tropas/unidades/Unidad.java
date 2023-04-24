package battleForFreedom.modelo.tropas.unidades;

import battleForFreedom.excepciones.AtaqueException;
import battleForFreedom.modelo.escenarios.Escenario;
import battleForFreedom.modelo.funcionamiento.Coordenada;
import battleForFreedom.modelo.tropas.seres.Ser;

/**
 *
 * @author Alvaro
 */
public abstract class Unidad {

    private int costeUnidad;
    private int energiaAtaque;
    private int energiaDefensa;
    private int energiaMovimiento;
    private int potenciaAtaque;
    private int puntosAnulado;
    private Coordenada posicion;
    private Ser[] seresUnidad;
    private Boolean unidadAnulada;

    /*
    *  Constructor completo, sera utilizado por las clases hijas
     */
    public Unidad(int costeUnidad, int energiaAtaque, int energiaDefensa, int energiaMovimiento, int potenciaAtaque, int puntosAnulado, Coordenada posicion, int numeroSeres) {
        this.costeUnidad = costeUnidad;
        this.energiaAtaque = energiaAtaque;
        this.energiaDefensa = energiaDefensa;
        this.energiaMovimiento = energiaMovimiento;
        this.potenciaAtaque = potenciaAtaque;
        this.puntosAnulado = puntosAnulado;
        this.posicion = posicion;
        this.seresUnidad = new Ser[numeroSeres];
        this.unidadAnulada = false;
    }

    public void setUnidadAnulada(Boolean unidadAnulada) {
        this.unidadAnulada = unidadAnulada;
    }

    public int atacar(Coordenada ataque, Escenario escenario) throws AtaqueException {
        int puntosGanados = 0;
        if (!enRangoAtaque(ataque)) {
            throw new AtaqueException("Fuera de rango");
        }
        if (this.energiaAtaque < this.potenciaAtaque) {
            throw new AtaqueException("Sin energía de ataque");
        }

        this.energiaAtaque = this.energiaAtaque - this.potenciaAtaque;

        if (escenario.getUnidadEscenario(ataque) == null) {
            throw new AtaqueException("Se ha atacado la posicion " + ataque + " pero estaba vacia");
        } else {
            if (escenario.getUnidadEscenario(ataque).unidadAnulada) {
                throw new AtaqueException("Se ha atacado la posicion " + ataque + " pero la unidad en dicha posicion ya estaba anulada");
            }

            if (escenario.getUnidadEscenario(ataque).energiaDefensa >= this.potenciaAtaque) {
                escenario.getUnidadEscenario(ataque).energiaDefensa = escenario.getUnidadEscenario(ataque).energiaDefensa - this.potenciaAtaque;
                System.out.println("Se ha atacado la posicion " + ataque + " donde habia un(a)"); //falta implementar el tipo de unidad
            } else {
                escenario.getUnidadEscenario(ataque).energiaDefensa = 0;

                float daño = (float) this.potenciaAtaque - escenario.getUnidadEscenario(ataque).energiaDefensa / escenario.getUnidadEscenario(ataque).seresUnidad.length;
                escenario.getUnidadEscenario(ataque).energiaDefensa = 0;
                int seresDerrotados = 0;

                for (int numeroSer = escenario.getUnidadEscenario(ataque).seresUnidad.length - 1; numeroSer >= 0; numeroSer--) {
                    float vidaSer = escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].getResistenciaAtaques();

                    if (vidaSer > 0) {
                        vidaSer = vidaSer - daño;
                        escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].setResistenciaAtaques(vidaSer);

                        if (vidaSer <= 0) {
                            escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].setSerAnulado(true);
                            puntosGanados = puntosGanados + escenario.getUnidadEscenario(ataque).seresUnidad[numeroSer].getPuntosAnulado();
                        }
                    }

                    if (vidaSer <= 0) {
                        seresDerrotados++;
                    }

                }

                if (seresDerrotados == escenario.getUnidadEscenario(ataque).seresUnidad.length) {
                    puntosGanados = puntosGanados + escenario.getUnidadEscenario(ataque).puntosAnulado;
                    escenario.getUnidadEscenario(ataque).setUnidadAnulada(true);
                }

            }
        }

        return puntosGanados;
    }

    public abstract Boolean enRangoAtaque(Coordenada coordenada);
}
