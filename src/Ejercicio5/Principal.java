package Ejercicio5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/** Lanza tres procesos antes de esperar a cualquiera de ellos. */
public class Principal {
    public static void main(String[] args) throws Exception {
        String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        ProcessBuilder processBuilderA = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio5.ProcesoTarea", "A", "5").inheritIO();
        ProcessBuilder processBuilderB = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio5.ProcesoTarea", "B", "3").inheritIO();
        ProcessBuilder processBuilderC = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio5.ProcesoTarea", "C", "2").inheritIO();

        Process procesoA = processBuilderA.start();
        Process procesoB = processBuilderB.start();
        Process procesoC = processBuilderC.start();

        procesoA.waitFor();
        procesoB.waitFor();
        procesoC.waitFor();
    }
}
