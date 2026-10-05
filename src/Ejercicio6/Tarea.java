package Ejercicio6;

/** Tarea temporizada que puede ejecutarse como proceso hijo. */
public class Tarea {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(Integer.parseInt(args[0]) * 1000L);
    }
}
