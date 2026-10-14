package Ejercicio7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/** Muestra tres tareas primero con Thread y después con procesos Java. */
public class CompararProcesosEHilos {
    public static void main(String[] args) throws Exception {
        Runnable tarea = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " iniciado");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " finalizado");
            } catch (InterruptedException e) {}
        };

        System.out.println("Inicio Hilos");
        Thread t1 = new Thread(tarea, "hilo-1");
        Thread t2 = new Thread(tarea, "hilo-2");
        Thread t3 = new Thread(tarea, "hilo-3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Fin Hilos");
        System.out.println();

        System.out.println("Inicio Procesos");
        String javaHome = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder processBuilder1 = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio5.ProcesoTarea", "Proceso-1", "1");
        ProcessBuilder processBuilder2 = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio5.ProcesoTarea", "Proceso-2", "1");
        ProcessBuilder processBuilder3 = new ProcessBuilder(javaHome, "-cp", classpath, "Ejercicio5.ProcesoTarea", "Proceso-3", "1");
        processBuilder1.inheritIO();
        processBuilder2.inheritIO();
        processBuilder3.inheritIO();

        Process p1 = processBuilder1.start();
        Process p2 = processBuilder2.start();
        Process p3 = processBuilder3.start();
        p1.waitFor();
        p2.waitFor();
        p3.waitFor();

        System.out.println("Fin Procesos");
    }
}
