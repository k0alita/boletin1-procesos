package Ejercicio12;

/** Calcula pares, impares y suma en un intervalo inclusivo. */
public class Trabajador {
    public static void main(String[] args) {
        long desde = Long.parseLong(args[0]), hasta = Long.parseLong(args[1]);
        long pares = 0, impares = 0;
        for (long n = desde; n <= hasta; n++) if ((n & 1L) == 0) pares++; else impares++;
        long cantidad = Math.max(0, hasta - desde + 1);
        long suma = cantidad == 0 ? 0 : (desde + hasta) * cantidad / 2;
        System.out.println(pares);
        System.out.println(impares);
        System.out.println(suma);
    }
}
