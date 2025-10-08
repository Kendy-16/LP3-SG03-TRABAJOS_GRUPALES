package controlador;

import java.util.*;
import modelo.Usuario;
import vista.VistaUsuario;

public class ControladorUsuario {
    public Vector<Usuario> lista = new Vector<>();
    private VistaUsuario vista;
    private Usuario usuarioActual;

    public ControladorUsuario(VistaUsuario vista) {
        this.vista = vista;
    }

    public boolean iniciarSistema() {
        int opcion;
        do {
            opcion = vista.menuAutenticacion();
            switch (opcion) {
                case 1:
                    usuarioActual = vista.registrarUsuario();
                    if (usuarioActual != null) {
                        lista.add(usuarioActual);
                        return true; 
                    }
                    break;
                case 2:
                    usuarioActual = vista.iniciarSesion(lista);
                    if (usuarioActual != null) {
                        return true;
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    return false;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (true);
    }

    public Usuario getUsuario() {
        return usuarioActual;
    }
    
    public void cerrarSesion() {
        usuarioActual = null;
    }
    
    public void mostrarUsuarios() {
        System.out.println("\n=== USUARIOS REGISTRADOS ===");
        for (Usuario u : lista) {
            System.out.println(u.getNombre() + " - " + u.getEmail() + " - " + u.getTipo());
        }
    }
}
