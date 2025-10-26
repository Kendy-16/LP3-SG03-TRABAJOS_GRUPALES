import java.util.Scanner;

public class GestorSeguridad {
    private static final String CLAVE = "admin123";
    private static Scanner lector = new Scanner(System.in);
    
    public static boolean verificarClave() {
        System.out.print("Ingrese la clave de seguridad para confirmar: ");
        String entrada = lector.nextLine();
        
        if (entrada.equals(CLAVE)) {
            System.out.println("Clave correcta - Operación confirmada");
            return true;
        } else {
            System.out.println("Clave incorrecta - Operación cancelada");
            return false;
        }
    }
}