import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Binarios2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        
        double[][] matriz;
        int filas, columnas, i, j;
        
        // Leer número de filas (positivo)
        do {
            System.out.print("Número de filas: ");
            filas = sc.nextInt();
        } while (filas <= 0);
        
        // Leer número de columnas (positivo)
        do {
            System.out.print("Número de columnas: ");
            columnas = sc.nextInt();
        } while (columnas <= 0);
        
        // Crear la matriz
        matriz = new double[filas][columnas];
        
        // Lectura de datos por teclado
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                System.out.print("matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }
        
        // Asegurarse de que exista la carpeta "ficheros"
        File dir = new File("ficheros");
        if (!dir.exists()) {
            dir.mkdirs(); // crea el directorio (y padres si es necesario)
        }
        
        try {
            // crear el fichero de salida
            fos = new FileOutputStream("ficheros/matriz.dat");
            salida = new DataOutputStream(fos);
            
            // escribir el número de filas y columnas en el fichero
            salida.writeInt(filas);
            salida.writeInt(columnas);
            
            // escribir la matriz en el fichero
            for (i = 0; i < filas; i++) {
                for (j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]);
                }
            }
            
            System.out.println("Matriz guardada en ficheros/matriz.dat");
            
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } finally {
            try {
                if (salida != null) {
                    salida.close(); // cierra también fos internamente
                } else if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error cerrando fichero: " + e.getMessage());
            }
            sc.close();
        }
    }
}
