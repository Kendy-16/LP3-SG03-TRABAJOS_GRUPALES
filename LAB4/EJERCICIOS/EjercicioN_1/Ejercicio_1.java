import java.util.Scanner;

public class Ejercicios_1 {
	
    public static void main(String[] args) {
        ManejoExcepciones app = new ManejoExcepciones();
        boolean continuar = true;
        
        System.out.println("Programa de manejo de excepciones");
        System.out.println("Ingrese caracteres (presione 's' para salir):");
        
        while (continuar) {
            try {
                app.procesar();
            } catch (Excepcion_de_vocal | Excepcion_de_numero | Excepcion_de_blanco e) {
                System.out.println(e.getMessage());
                System.out.println("Continuando con la lectura...");
                
            } catch (Excepcion_de_salida e) {
                System.out.println(e.getMessage());
                continuar = false;
            }
        }
        
        System.out.println("Programa terminado.");
    }
}
