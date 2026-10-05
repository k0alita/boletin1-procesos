package Ejercicio3;

/** Calcula el cuadrado y lo devuelve como código de salida (solo demostrativo). */
public class Hijo {
    public static void main(String[] args) {
        if (args.length > 0) {
            int numero = Integer.parseInt(args[0]);
            int resultado = numero * numero;
            System.exit(resultado);
        } else {
            System.exit(-1);
        }
    }
}
