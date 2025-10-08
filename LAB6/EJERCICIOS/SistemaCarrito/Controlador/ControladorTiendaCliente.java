package controlador;

import modelo.*;
import vista.*;

public class ControladorTiendaCliente {
    private final Carrito carrito = new Carrito();
    private final HistorialCompras historial = new HistorialCompras();
    private final DescuentoVerano descuento = new DescuentoVerano();
    private final CalculadoraEnvio calculadora = new CalculadoraEnvio();
    private final VistaTiendaCliente vista;
    private final Cliente cliente;
    private final ControladorUsuario ctrlUsuario;

    public ControladorTiendaCliente(VistaTiendaCliente vista, Cliente cliente, ControladorUsuario ctrlUsuario) {
        this.vista = vista;
        this.cliente = cliente;
        this.ctrlUsuario = ctrlUsuario;
    }
    
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> agregarProductoDelInventario();
                case 2 -> vista.mostrarCarrito(carrito);
                case 3 -> carrito.eliminarProducto(vista.pedirCodigo());
                case 4 -> vista.mostrarDescuento(descuento.descuentoFijo(carrito), carrito.totalPrecio());
                case 5 -> calculadora.calcularCosto(carrito, vista.pedirDireccion());
                case 6 -> realizarCompra();
                case 7 -> historial.mostrarHistorial();
                case 8 -> vista.registrarResena(cliente);
                case 0 -> {
                    System.out.println("Saliendo del panel cliente...");
                    ctrlUsuario.iniciarSistema();
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void realizarCompra() {
        if (carrito.estaVacio()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        historial.registrarCompra(carrito);
        carrito.vaciarCarrito();
        System.out.println("Compra realizada con éxito.");
    }

    private void agregarProductoDelInventario() {
    if (ControladorTiendaAdmin.getInventario().isEmpty()) {
        System.out.println("No hay productos disponibles. Espera a que el administrador los agregue.");
        return;
    }

    System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
    int i = 1;
    for (Producto p : ControladorTiendaAdmin.getInventario()) {
        System.out.println(i++ + ". " + p);
    }

    int opcion = vista.pedirNumero("Seleccione el número del producto a agregar: ");
    if (opcion >= 1 && opcion <= ControladorTiendaAdmin.getInventario().size()) {
        Producto p = ControladorTiendaAdmin.getInventario().get(opcion - 1);
        carrito.agregarProducto(p);
        System.out.println("Producto agregado al carrito: " + p.getNombre());
    } else {
        System.out.println("Selección inválida.");
    }
}
}
