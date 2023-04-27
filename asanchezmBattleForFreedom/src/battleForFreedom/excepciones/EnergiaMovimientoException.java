package battleForFreedom.excepciones;

/**
 *
 * @author Alvaro
 */
public class EnergiaMovimientoException extends Exception {

    private int energiaMovimientoRestante;
    private int gastoEnergiaMinimo;

    /**
     * Constructor de la excepcion.Los parametros que inicializan sus atributos
     * se usan para determinar si la unidad aún tiene energía suficiente para
     * moverse, aunque una distancia menor de la que se ha intentado, o si la
     * unidad no tiene energia para moverse una sola casilla.En cada caso se
     * tratará la excepción de forma distinta.
     *
     * @param energiaMovimientoRestante Energia restate de la unidad
     * @param gastoEnergiaMinimo Gasto de movimiento por casilla
     */
    public EnergiaMovimientoException(int energiaMovimientoRestante, int gastoEnergiaMinimo) {
        this.energiaMovimientoRestante = energiaMovimientoRestante;
        this.gastoEnergiaMinimo = gastoEnergiaMinimo;
    }

    public Boolean quedaEnergia() {
        Boolean resultado = true;

        if (this.energiaMovimientoRestante < this.gastoEnergiaMinimo) {
            resultado = false;
        }
        return resultado;
    }
}
