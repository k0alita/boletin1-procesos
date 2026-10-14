package Ejercicio9;

/** Hijo que suma dos números e imprime el resultado por stdout. */
public class Calculadora {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a + b);
    }
}
