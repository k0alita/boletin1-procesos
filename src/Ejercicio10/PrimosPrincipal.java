package Ejercicio10;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** Compara la búsqueda de primos secuencial y en cuatro procesos. */
public class PrimosPrincipal {
    public static void main(String[] args) throws Exception {
        String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        long inicioTiempo = System.currentTimeMillis();

        int[][] rangos = {
                {1, 250000},
                {250001, 500000},
                {500001, 750000},
                {750001, 1000000}
        };

        List<Process> procesos = new ArrayList<>();
        for (int[] r : rangos) {
            ProcessBuilder processBuilder = new ProcessBuilder(javaHome, "-cp", classpath, "BuscadorPrimos", String.valueOf(r[0]), String.valueOf(r[1]));
            procesos.add(processBuilder.start());
        }

        int totalPrimos = 0;
        for (Process p : procesos) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                totalPrimos += Integer.parseInt(reader.readLine());
            }
            p.waitFor();
        }
        long finTiempo = System.currentTimeMillis();

        System.out.println("Número de primos encontrados: " + totalPrimos);
        System.out.println("Tiempo empleado: " + (finTiempo - inicioTiempo) + " ms");
    }
}
