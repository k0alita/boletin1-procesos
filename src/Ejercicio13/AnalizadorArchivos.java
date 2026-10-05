package Ejercicio13;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Proceso hijo: analiza la parte de archivos asignada desde un directorio. */
public class AnalizadorArchivos {
    public static void main(String[] args) {
        if (args.length != 3) { System.err.println("Uso: AnalizadorArchivos <directorio> <indice> <procesos>"); System.exit(2); }
        try {
            Path carpeta = Paths.get(args[0]);
            int indice = Integer.parseInt(args[1]), procesos = Integer.parseInt(args[2]);
            if (!Files.isDirectory(carpeta) || procesos < 1 || indice < 0 || indice >= procesos) throw new IllegalArgumentException("Directorio o partición no válidos");
            List<Path> archivos;
            try (Stream<Path> listado = Files.walk(carpeta)) {
                archivos = listado.filter(Files::isRegularFile).sorted().collect(Collectors.toList());
            }
            long numArchivos = 0, lineas = 0, palabras = 0, caracteres = 0;
            for (int i = indice; i < archivos.size(); i += procesos) {
                List<String> contenido = Files.readAllLines(archivos.get(i), Charset.defaultCharset());
                numArchivos++;
                lineas += contenido.size();
                for (String linea : contenido) {
                    String limpia = linea.trim();
                    if (!limpia.isEmpty()) palabras += limpia.split("\\s+").length;
                    caracteres += linea.length();
                }
            }
            System.out.println(numArchivos + " " + lineas + " " + palabras + " " + caracteres);
        } catch (Exception e) {
            System.err.println("Error al analizar archivos: " + e.getMessage());
            System.exit(1);
        }
    }
}
