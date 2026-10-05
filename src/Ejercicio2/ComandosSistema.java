package Ejercicio2;

import MiEntradaSalida.MiEntradaSalida;

public class ComandosSistema {
    public static void main(String[] args) throws Exception {
        try {
            boolean esWindows = System.getProperty("os.name").toLowerCase().contains("win");
            ProcessBuilder builder;

            if (esWindows) {
                builder = new ProcessBuilder("ipconfig");
            } else {
                builder = new ProcessBuilder("ip", "addr");
            }

            Process proceso = builder.start();

            System.out.println("Salida comando: ");
            MiEntradaSalida.mostrarStream(proceso.getInputStream());
            System.out.println("Salida errores: ");
            MiEntradaSalida.mostrarStream(proceso.getErrorStream());

            int codigoSalida = proceso.waitFor();
            System.out.println("Proceso finalizado: " + codigoSalida);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
