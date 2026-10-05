package Ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/** Lee un entero de stdin y escribe su cuadrado en stdout. */
public class Hijo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int numero = scanner.nextInt();
            int resultado = numero * numero;
            System.out.println(resultado);
        }
    }
}
