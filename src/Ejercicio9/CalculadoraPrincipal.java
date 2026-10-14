package Ejercicio9;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** Recoge por stdout los resultados de cuatro procesos suma. */
public class CalculadoraPrincipal {
    public static void main(String[] args) throws Exception {
        String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        int[][] datos = {{5, 3}, {10, 2}, {20, 4}, {7, 8}};
        List<Process> procesos = new ArrayList<>();

        for (int[] par : datos) {
            ProcessBuilder processBuilder = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio9.Calculadora", String.valueOf(par[0]), String.valueOf(par[1]));
            procesos.add(processBuilder.start());
        }

        for (int i = 0; i < procesos.size(); i++) {
            Process p = procesos.get(i);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String res = reader.readLine();
                System.out.println("Resultado " + (i + 1) + ": " + res);
            }
            p.waitFor();
        }
    }
}
