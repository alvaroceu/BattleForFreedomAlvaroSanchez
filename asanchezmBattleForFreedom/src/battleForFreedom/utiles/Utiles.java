package battleForFreedom.utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alvaro
 */
public class Utiles {

    /**
     * Metodo que permite introducir una cadena de caracteres.
     *
     * @param mensaje Se mostrará al pedir la cadena
     * @return Cadena introducida
     */
    public static String leerCadena(String mensaje) {

        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        String linea = "";
        System.out.print(mensaje);
        try {
            linea = consola.readLine();
        } catch (IOException ex) {
            System.out.println("Error de lectura por entrada estandar");
        }

        return linea;
    }

    /**
     * Metodo que permite introducir un numero entero
     *
     * @param mensaje Se monstrará al pedir el numero entero.
     * @return Numero entero introducido
     */
    public static int leerEntero(String mensaje) {

        String linea;
        int numero = 0;
        boolean lecturaCorrecta = false;

        while (!lecturaCorrecta) {

            try {
                linea = leerCadena(mensaje);
                numero = Integer.parseInt(linea);
                lecturaCorrecta = true;

            } catch (NumberFormatException nfe) {
                System.out.println("Debe introducir un numero, por favor, repita");
            }
        }

        return numero;
    }
}
