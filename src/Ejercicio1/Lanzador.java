package Ejercicio1;

public class Lanzador {
    public static void main(String[] args) throws Exception {
        try {
            String programa = System.getProperty("os.name").toLowerCase().contains("win") ? "notepad.exe" : "xed";
            ProcessBuilder builder = new ProcessBuilder(programa);

            Process proceso = builder.start();

            System.out.println("PID: " + proceso.pid());

            int codigo = proceso.waitFor();

            System.out.println("Código de salida: " + codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
