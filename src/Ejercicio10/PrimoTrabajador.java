package Ejercicio10;

/** Busca primos en un intervalo inclusivo y emite uno por línea. */
public class PrimoTrabajador {
    public static void main(String[] args) {
        int desde = Integer.parseInt(args[0]), hasta = Integer.parseInt(args[1]);
        StringBuilder salida = new StringBuilder();
        for (int n = Math.max(2, desde); n <= hasta; n++) if (esPrimo(n)) salida.append(n).append('\n');
        System.out.print(salida);
    }
    static boolean esPrimo(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int d = 3; (long) d * d <= n; d += 2) if (n % d == 0) return false;
        return true;
    }
}
