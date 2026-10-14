package Ejercicio8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/** Lanza cinco calculadores y espera a todos antes de finalizar. */
public class Principal {
    public static void main(String[] args) throws Exception {
        String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        int[] numeros = {10, 20, 30, 40, 50};
        List<Process> procesos = new ArrayList<>();

        for (int n : numeros) {
            ProcessBuilder processBuilder = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio8.Calculador", String.valueOf(n)).inheritIO();
            procesos.add(processBuilder.start());
        }

        for (Process p : procesos) {
            p.waitFor();
        }

        System.out.println("Todos los procesos han terminado");

    }
}
