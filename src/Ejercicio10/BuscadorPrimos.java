package Ejercicio10;

/** Busca primos en un intervalo inclusivo y emite uno por línea. */
public class BuscadorPrimos {
    public static void main(String[] args) {
        int inicio = Integer.parseInt(args[0]);
        int fin = Integer.parseInt(args[1]);
        int contador = 0;

        for (int i = inicio; i <= fin ; i++) {
            if (esPrimo(i)) contador++;
        }
        System.out.println(contador);
    }

    private static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}
