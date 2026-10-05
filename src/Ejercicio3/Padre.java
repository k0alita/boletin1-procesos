package Ejercicio3;

import java.io.File;

/** Inicia Hijo con un argumento y obtiene su código de salida. */
public class Padre {
    public static void main(String[] args) throws Exception {
        try {
            String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            String classpath = System.getProperty("java.class.path");

            ProcessBuilder builder = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio3.Hijo", "10");
            Process proceso = builder.start();

            int resultado = proceso.waitFor();
            System.out.println("Resultado recibido: " + resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
