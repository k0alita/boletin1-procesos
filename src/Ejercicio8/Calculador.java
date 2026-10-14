package Ejercicio8;

/** Proceso hijo que calcula el cuadrado del número recibido. */
public class Calculador {
    public static void main(String[] args) {
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            System.out.println("El cuadrado de " + n + " es " + (n * n));
        }
    }
}
