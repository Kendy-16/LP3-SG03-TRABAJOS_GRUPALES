package vista;

import java.util.Scanner;
import modelo.*;

public class VistaTiendaCliente {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== MENÚ CLIENTE ===");
        System.out.println("1. Agregar producto al carrito");
        System.out.println("2. Ver carrito");
        System.out.println("3. Eliminar producto del carrito");
        System.out.println("4. Aplicar descuento");
        System.out.println("5. Calcular costo de envío");
        System.out.println("6. Realizar compra");
        System.out.println("7. Ver historial");
        System.out.println("8. Dejar reseña");
        System.out.println("0. Cerrar sesión");
        System.out.print("Opción: ");
        return Integer.parseInt(sc.nextLine());
    }

    public Producto crearProducto() {
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        System.out.print("Peso (kg): ");
        double p = Double.parseDouble(sc.nextLine());
        System.out.print("Precio: ");
        double pr = Double.parseDouble(sc.nextLine());
        System.out.print("Categoría: ");
        String c = sc.nextLine();
        System.out.print("Código: ");
        String cod = sc.nextLine();
        System.out.print("Descripción: ");
        String d = sc.nextLine();
        return new Producto(n, p, pr, c, cod, d);
    }

    public void mostrarCarrito(Carrito carrito) {
        System.out.println(carrito);
    }

    public String pedirCodigo() {
        System.out.print("Código del producto: ");
        return sc.nextLine();
    }

    public String pedirDireccion() {
        System.out.print("Dirección: ");
        return sc.nextLine();
    }

    public void mostrarDescuento(double totalConDesc, double totalSinDesc) {
        System.out.println("Total sin descuento: S/ " + totalSinDesc);
        System.out.println("Total con descuento: S/ " + totalConDesc);
    }

    public void registrarResena(Cliente cliente) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Calificación (1-5): ");
        int cal = Integer.parseInt(sc.nextLine());
        System.out.print("Comentario: ");
        String com = sc.nextLine();

        Producto producto = new Producto(nombre, 0, 0, "", "temp", "");
        Resena resena = new Resena(cliente, producto, cal, com);
        resena.mostrarResena();
    }

    public int pedirNumero(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }
}
