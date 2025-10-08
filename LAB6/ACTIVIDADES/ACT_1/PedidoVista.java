import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    // Crea el scanner para leer entradas por teclado
    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // Pide al usuario el nombre del plato
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    // Muestra la lista de pedidos
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido.getNombrePlato());
            }
        }
    }

    // Muestra las opciones del menú
    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Salir");
    }

    // Solicita la opción elegida por el usuario
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    // Muestra un mensaje cualquiera
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Cierra el scanner cuando se termina la aplicación
    public void cerrarScanner() {
        scanner.close();
    }
}
