package Ejercicio6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/** Compara tres pausas de cuatro segundos en serie y en procesos concurrentes. */
public class CompararEjecucion {
    public static void main(String[] args) throws Exception {
        String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        long inicioSecuencial = System.currentTimeMillis();
        for (int i = 1; i <= 3 ; i++) {
            Process p = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio6.CompararEjecucion", "Tarea" + i, "4").start();
            p.waitFor();
        }
        long finSecuencial = System.currentTimeMillis();
        System.out.println("Tiempo versión secuencial: " + (finSecuencial - inicioSecuencial) + " ms");

        long inicioParalero = System.currentTimeMillis();
        List<Process> procesos = new ArrayList<>();
        for (int i = 1; i <= 3 ; i++) {
            procesos.add(new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio6.CompararEjecucion", "Tarea" + i, "4").start());
        }
        for (Process p : procesos) {
            p.waitFor();
        }
        long finParalelo = System.currentTimeMillis();
        System.out.println("Tiempo versión paralela: " + (finParalelo - inicioParalero) + " ms");
    }
}
