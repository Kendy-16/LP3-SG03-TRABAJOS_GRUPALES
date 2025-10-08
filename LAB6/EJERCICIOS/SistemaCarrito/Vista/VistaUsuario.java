package vista;

import java.util.Scanner;
import java.util.Vector;
import modelo.*;

public class VistaUsuario {
    private Scanner sc = new Scanner(System.in);

    public int menuAutenticacion() {
        System.out.println("\n=== SISTEMA DE AUTENTICACION ===");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar Sesion");
        System.out.println("3. Salir");
        System.out.print("Opcion: ");
        return sc.nextInt();
    }

    public Usuario registrarUsuario() {
        sc.nextLine();  // Limpiar el buffer
        System.out.println("\n=== REGISTRO DE USUARIO ===");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        System.out.println("Seleccione tipo de usuario:");
        System.out.println("1. Cliente");
        System.out.println("2. Administrador");
        int tipo = sc.nextInt();

        Usuario nuevo = null;
        switch (tipo) {
            case 1:
                nuevo = new Cliente(nombre, email, pass);
                break;
            case 2:
                nuevo = new Administrador(nombre, email, pass);
                break;
            default:
                System.out.println("Tipo de usuario no válido. Ingrese nuevamente:");
                tipo = sc.nextInt();
                // Repetir la selección usando recursividad o bucle
                return registrarUsuario();
        }
        System.out.println("Usuario registrado con éxito como " + nuevo.getTipo());
        return nuevo;
    }

    public Usuario iniciarSesion(Vector<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados. Por favor, regístrese primero.");
            return null;
        }
        sc.nextLine();
        
        while (true) { 
            System.out.println("\n=== INICIO DE SESION ===");
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Contraseña: ");
            String pass = sc.nextLine();

            for (Usuario u : usuarios) {
                if (u.getEmail().equals(email) && u.getContrasena().equals(pass)) {
                    System.out.println("Inicio de sesión exitoso. Bienvenido " + u.getNombre() + " (" + u.getTipo() + ")");
                    return u;
                }
            }
            
            System.out.println("Credenciales incorrectas.");
            System.out.println("1. Intentar nuevamente");
            System.out.println("2. Volver al menú principal");
            System.out.print("Opción: ");
            
            int opcion;
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                opcion = 0;
            }
            sc.nextLine(); 
            
            if (opcion == 2) {
                return null; 
            } else if (opcion != 1) {
                System.out.println("Opción inválida, intentando nuevamente...");
            }
        }
    }
}
