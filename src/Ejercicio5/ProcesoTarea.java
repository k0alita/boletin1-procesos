package Ejercicio5;

/** Modo hijo que simula una tarea con una pausa. */
public class ProcesoTarea {
    public static void main(String[] args) throws InterruptedException {
        String nombre = args[0];
        int segundos = Integer.parseInt(args[1]);

        System.out.println("Proceso " + nombre + " iniciado");
        Thread.sleep(segundos * 1000L);
        System.out.println("Proceso " + nombre + " finalizado");
    }
}
