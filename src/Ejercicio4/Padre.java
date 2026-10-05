package Ejercicio4;

import java.io.*;

/** Envía un número al hijo por stdin y recoge la respuesta por stdout. */
public class Padre {
    public static void main(String[] args) throws Exception {
        try {
            String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            String classpath = System.getProperty("java.class.path");

            ProcessBuilder builder = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio4.Hijo", "10");
            Process proceso = builder.start();
            try (PrintWriter writer = new PrintWriter(proceso.getOutputStream(), true)) {
                writer.println("10");
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String resultado = reader.readLine();
                System.out.println("Resultado recibido: " + resultado);
            }

            proceso.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
