package MiEntradaSalida;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MiEntradaSalida {

    public static void mostrarStream(InputStream stream) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String linea;
            while((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}
