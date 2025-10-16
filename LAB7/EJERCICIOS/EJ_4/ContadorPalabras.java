import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;

public class ContadorPalabras {

    public static void main(String[] args) {
        // Permitimos al usuario elegir un archivo hasta que es válido o cancela.
        File archivo = seleccionarArchivo();
        if (archivo == null) {
            System.out.println("No se seleccionó ningún archivo. Fin del programa.");
            return;
        }

        BufferedReader br = null;
        long totalLineas = 0;
        long totalCaracteres = 0; // no contamos los '\n' / finales de línea
        long totalPalabras = 0;
        Map<String, Integer> frecuencias = new HashMap<>();

        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea;
            // Leemos el archivo línea por línea (eficiente para archivos de texto)
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length(); // readLine() ya quita el '\n'
                // Recorremos la línea carácter por carácter para formar "palabras"
                StringBuilder token = new StringBuilder();
                for (int i = 0; i < linea.length(); i++) {
                    char c = linea.charAt(i);
                    if (Character.isLetterOrDigit(c)) {
                        token.append(c);
                    } else {
                        if (token.length() > 0) {
                            String palabra = token.toString().toLowerCase();
                            totalPalabras++;
                            frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                            token.setLength(0);
                        }
                    }
                }
                // Si la línea termina dentro de una palabra, la procesamos también
                if (token.length() > 0) {
                    String palabra = token.toString().toLowerCase();
                    totalPalabras++;
                    frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
            return;
        } finally {
            // Cerramos el BufferedReader si se abrió
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignored) { }
            }
        }

        double promedioPalabrasPorLinea = (totalLineas > 0) ? (double) totalPalabras / totalLineas : 0.0;

        // Ordenamos las palabras por frecuencia descendente para mostrar las más comunes
        List<Entry<String, Integer>> lista = new ArrayList<>(frecuencias.entrySet());
        lista.sort(new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return Integer.compare(e2.getValue(), e1.getValue()); // descendente
            }
        });

        // Mostramos resultados en consola
        System.out.println("Archivo: " + archivo.getAbsolutePath());
        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres (sin contar finales de línea): " + totalCaracteres);
        System.out.printf("Promedio de palabras por línea: %.3f%n", promedioPalabrasPorLinea);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron palabras en el archivo.");
            return;
        }

        // Mostramos las palabras más frecuentes.
        // Primero, mostramos las 10 más frecuentes (o menos si hay menos palabras).
        System.out.println("\nTop palabras más frecuentes (máx. 10):");
        int mostrar = Math.min(10, lista.size());
        for (int i = 0; i < mostrar; i++) {
            Entry<String, Integer> e = lista.get(i);
            System.out.printf("%d) \"%s\"  -> %d veces%n", i + 1, e.getKey(), e.getValue());
        }

        // Además, listamos todas las palabras que tengan la frecuencia máxima (si hay empates)
        int maxFreq = lista.get(0).getValue();
        List<String> maxima = new ArrayList<>();
        for (Entry<String, Integer> e : lista) {
            if (e.getValue() == maxFreq) maxima.add(e.getKey());
            else break;
        }
        System.out.println("\nPalabra(s) con mayor frecuencia (" + maxFreq + " veces): " + maxima);
    }

    // Método sencillo para abrir un JFileChooser y devolver el archivo seleccionado
    private static File seleccionarArchivo() {
        while (true) {
            JFileChooser chooser = new JFileChooser();
            int res = chooser.showOpenDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                if (f.exists() && f.isFile() && f.canRead()) {
                    return f;
                } else {
                    System.out.println("Archivo inválido o sin permisos de lectura. Seleccione otro archivo.");
                    // el bucle vuelve a mostrar el JFileChooser
                }
            } else {
                // Usuario canceló
                return null;
            }
        }
    }
}
