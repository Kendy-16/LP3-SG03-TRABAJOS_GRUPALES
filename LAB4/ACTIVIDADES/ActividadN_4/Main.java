import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Path reporte1 = Paths.get("reporte_A001.txt");
        Path reporte2 = Paths.get("reporte_B002.txt");
        Path archivoInexistente = Paths.get("archivo_que_no_existe.txt");

        // Cuenta sin transacciones (si en constructor registramos CREACION, getTransacciones no estará vacío
        // para demostrar el caso vacío crea una cuenta nueva y limpia su historial para el test)
        CuentaBancaria cuentaVacia = new CuentaBancaria("A001", "UsuarioVacio");
        
        // la cuenta creada sin operaciones tiene historial vacío.
        // PRUEBA: generar reporte cuenta sin transacciones -> debe lanzar HistorialVacioException
        try {
            System.out.println("\n-- Generando reporte para cuenta sin transacciones --");
            ReporteTransacciones.generarReporte(cuentaVacia, reporte1);
            System.out.println("Reporte generado: " + reporte1.toAbsolutePath());
            
        } catch (HistorialVacioException e) {
            System.out.println("No se generó el reporte: " + e.getMessage());
            
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }


        // Crear cuenta con algunas transacciones y generar reporte correctamente
        CuentaBancaria cuenta = new CuentaBancaria("B002", "Kendy", 100.0);
        // realizar operaciones
        cuenta.depositar(50.0); // registra deposito
        try {
            cuenta.retirar(30.0); // registra retiro
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo Insuficiente: " + e.getMessage());
        }

        // Generar reporte usando try-with-resources internamente en ReporteTransacciones
        try {
            System.out.println("\n-- Generando reporte para cuenta con transacciones --");
            ReporteTransacciones.generarReporte(cuenta, reporte2);
            System.out.println("Reporte generado en: " + reporte2.toAbsolutePath());
        } catch (HistorialVacioException e) {
            System.out.println("HistorialVacioException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
        }

        // Leer archivo existente con Scanner (try-with-resources usado en la función)
        try {
            System.out.println("\n-- Leyendo reporte generado --\n");
            List<String> lineas = ReporteTransacciones.leerTransaccionesDesdeArchivo(reporte2);
            for (String l : lineas) System.out.println(l);
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        // Intentar leer archivo inexistente -> FileNotFoundException (es IOException)
        try {
            System.out.println("\n-- Intentando leer archivo inexistente --");
            List<String> lineas = ReporteTransacciones.leerTransaccionesDesdeArchivo(archivoInexistente);
            System.out.println("Se leyeron " + lineas.size() + " lineas.");
        } catch (IOException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }

    }
}
