package Ejercicio8;

/** Proceso hijo que calcula el cuadrado del número recibido. */
public class Calculador {
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(n + "^2 = " + (n * n));
    }
}
