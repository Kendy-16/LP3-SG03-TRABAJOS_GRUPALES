package vista;

import java.util.Scanner;
import java.util.Vector;
import modelo.*;

public class VistaTiendaAdmin {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenuAdmin() {
        System.out.println("\n=== PANEL ADMINISTRADOR ===");
        System.out.println("1. Agregar producto al inventario");
        System.out.println("2. Eliminar producto del inventario");
        System.out.println("3. Ver inventario");
        System.out.println("0. Salir");
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

    public String pedirCodigo() {
        System.out.print("Código del producto: ");
        return sc.nextLine();
    }

    public void mostrarInventario(Vector<Producto> inventario) {
        if (inventario.isEmpty()) System.out.println("Inventario vacío.");
        else inventario.forEach(producto -> System.out.println(producto.toString()));
    }
}
