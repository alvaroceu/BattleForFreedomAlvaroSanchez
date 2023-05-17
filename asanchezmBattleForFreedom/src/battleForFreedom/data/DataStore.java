package battleForFreedom.data;

import battleForFreedom.modelo.partida.Partida;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class DataStore {

    private static final String nombreFichero = "fichero-partidas-avatarBattle.bin";

    public static void escribirPartida(List<Partida> partidas) {

        File fichero = new File(nombreFichero);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(partidas);

        } catch (IOException ioe) {
            System.out.println("Ha ocurrido un error al escribir los datos.");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("No puedo cerrar flujo de datos DOS.");
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ioe) {
                    System.out.println("No puedo cerrar flujo de datos FOS");
                }
            }
        }
    }

    public static List<Partida> leerPartida() {

        File fichero = new File(nombreFichero);
        FileInputStream fos = null;
        ObjectInputStream oos = null;
        List<Partida> partidas = null;

        try {
            fos = new FileInputStream(fichero);
            oos = new ObjectInputStream(fos);

            partidas = (List<Partida>) oos.readObject();

        } catch (Exception ioe) {
            System.out.println("Ha ocurrido un error al leer los datos.");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("No puedo cerrar flujo de datos DOS.");
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ioe) {
                    System.out.println("No puedo cerrar flujo de datos FOS");
                }
            }
        }

        return partidas;
    }

}
