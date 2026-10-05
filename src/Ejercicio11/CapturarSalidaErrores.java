package Ejercicio11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** Demuestra la separación y la combinación de stdout y stderr. */
public class CapturarSalidaErrores {
    public static void main(String[] args) throws Exception {
        boolean windows = System.getProperty("os.name").toLowerCase().contains("win");
        ProcessBuilder separado = windows
                ? new ProcessBuilder("cmd", "/c", "comando_que_no_existe")
                : new ProcessBuilder("sh", "-c", "comando_que_no_existe");
        Process segundo = separado.start();
        mostrar("stdout", segundo.getInputStream());
        mostrar("stderr", segundo.getErrorStream());
        System.out.println("Código de salida: " + segundo.waitFor());

        ProcessBuilder combinado = windows
                ? new ProcessBuilder("cmd", "/c", "comando_que_no_existe")
                : new ProcessBuilder("sh", "-c", "comando_que_no_existe");
        combinado.redirectErrorStream(true);
        Process proceso = combinado.start();
        mostrar("flujo combinado", proceso.getInputStream());
        System.out.println("Código de salida: " + proceso.waitFor());
        System.out.println("stdout contiene la salida normal; stderr contiene errores. redirectErrorStream(true) combina ambos en getInputStream(), útil para consumir una sola salida conservando el orden aproximado.");
    }
    private static void mostrar(String etiqueta, java.io.InputStream flujo) throws Exception {
        System.out.println("--- " + etiqueta + " ---");
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(flujo))) {
            String linea;
            while ((linea = lector.readLine()) != null) System.out.println(linea);
        }
    }
}
