import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ReporteTransacciones {

    // Genera un reporte en texto. Lanza HistorialVacioException si no hay transacciones.
    public static void generarReporte(CuentaBancaria cuenta, Path archivoSalida)
            throws HistorialVacioException, IOException {
        List<String> trans = cuenta.getTransacciones();
        if (trans.isEmpty()) {
            throw new HistorialVacioException("La cuenta " + cuenta.getNumeroCuenta() + " no tiene transacciones.");
        }

        // try-with-resources: garantiza cierre del BufferedWriter incluso si ocurre IOException
        try (BufferedWriter writer = Files.newBufferedWriter(archivoSalida, StandardCharsets.UTF_8)) {
            writer.write("REPORTE DE TRANSACCIONES\n");
            writer.write("NumeroCuenta:" + cuenta.getNumeroCuenta() + "\n");
            writer.write("Titular:" + cuenta.getTitular() + "\n");
            writer.write("Saldo:" + cuenta.getSaldo() + "\n");
            writer.write("---------------------------------------------------------\n");
            writer.write("  TIPO   --        FECHA        -- MONTO -- SALDO_DESPUES\n");
            writer.write("---------------------------------------------------------\n");
            for (String linea : trans) {
                writer.write(linea);
                writer.write("\n");
            }
            writer.write("---------------------------------------------------------\n");
        }
    }

    // Lee las transacciones desde un archivo de texto usando Scanner y devuelve las líneas
    public static List<String> leerTransaccionesDesdeArchivo(Path archivoEntrada) throws IOException {
        // FileNotFoundException es una subclase de IOException; el caller puede capturarlo si quiere.
        File file = archivoEntrada.toFile();

        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            java.util.ArrayList<String> lineas = new java.util.ArrayList<>();
            while (scanner.hasNextLine()) {
                lineas.add(scanner.nextLine());
            }
            return lineas;
        }
    }
}
