package controlador;

import modelo.*;
import vista.*;
import java.util.Vector;

public class ControladorTiendaAdmin {
    private static Vector<Producto> inventario = new Vector<>();
    private final VistaTiendaAdmin vista;
    private final Administrador admin;
    private final ControladorUsuario ctrlUsuario;

    public ControladorTiendaAdmin(VistaTiendaAdmin vista, Administrador admin, ControladorUsuario ctrlUsuario) {
        this.vista = vista;
        this.admin = admin;
        this.ctrlUsuario = ctrlUsuario; 
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenuAdmin();
            switch (opcion) {
                case 1 -> inventario.add(vista.crearProducto());
                case 2 -> eliminarProducto();
                case 3 -> vista.mostrarInventario(inventario);
                case 0 -> {
                    System.out.println("Saliendo del panel admin...");
                    ctrlUsuario.iniciarSistema();
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void eliminarProducto() {
    String codigo = vista.pedirCodigo();
    boolean eliminado = inventario.removeIf(p -> p.getIdentificador().equalsIgnoreCase(codigo));
    if (eliminado) {
        System.out.println("Producto eliminado correctamente.");

        // Eliminarlo también de los carritos activos (si aún no compraron)
        Carrito.removerDeTodosLosCarritos(codigo);
    } else {
        System.out.println("Producto no encontrado.");
    }
   }


    public static Vector<Producto> getInventario() {
        return inventario;
    }
}
