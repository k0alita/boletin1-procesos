package Ejercicio6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompararEjecucion {
    public static void main(String[] args) throws Exception {
        if (args.length >= 2) {
            String nombreTarea = args[0];
            int segundos = Integer.parseInt(args[1]);

            System.out.println(nombreTarea + " iniciada");
            Thread.sleep(segundos * 1000L);
            System.out.println(nombreTarea + " finalizada");
            return;
        }

        String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        long inicioSecuencial = System.currentTimeMillis();
        for (int i = 1; i <= 3; i++) {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    javaHome, "-cp", classpath, "Ejercicio6.CompararEjecucion", "Tarea" + i, "4"
            );
            processBuilder.inheritIO();
            Process p = processBuilder.start();
            p.waitFor();
        }
        long finSecuencial = System.currentTimeMillis();
        System.out.println("Tiempo versión secuencial: " + (finSecuencial - inicioSecuencial) + " ms");
        System.out.println();

        long inicioParalero = System.currentTimeMillis();
        List<Process> procesos = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    javaHome, "-cp", classpath, "Ejercicio6.CompararEjecucion", "Tarea" + i, "4"
            );
            processBuilder.inheritIO();
            procesos.add(processBuilder.start());
        }
        for (Process p : procesos) {
            p.waitFor();
        }
        long finParalelo = System.currentTimeMillis();
        System.out.println("Tiempo versión paralela: " + (finParalelo - inicioParalero) + " ms");
    }
}