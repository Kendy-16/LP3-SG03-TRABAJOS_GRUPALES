import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // Pide nombre del plato
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    // Pide tipo del plato
    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo del plato (ej: Entrada, Principal, Postre, etc): ");
        return scanner.nextLine();
    }

    // Pide índice (usa nextInt y limpia buffer)
    public int solicitarIndice() {
        System.out.print("Introduce el índice del pedido: ");
        int idx = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return idx;
    }

    // Muestra la lista de pedidos con índice, nombre y tipo
    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido p = pedidos.get(i);
                System.out.println(i + ". " + p.getNombrePlato() + " (Tipo: " + p.getTipo() + ")");
            }
        }
    }

    // Muestra menú ampliado con nuevas opciones
    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
    }

    // Solicita opción
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    // Muestra mensajes simples
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Muestra resultados de búsqueda
    public void mostrarPedidosEncontrados(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No se encontraron pedidos.");
        } else {
            System.out.println("Pedidos encontrados:");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido p = pedidos.get(i);
                System.out.println("- " + p.getNombrePlato() + " (Tipo: " + p.getTipo() + ")");
            }
        }
    }

    // Muestra conteo total
    public void mostrarConteoTotal(int total) {
        System.out.println("Total de pedidos: " + total);
    }

    // Muestra conteo por tipo
    public void mostrarConteoPorTipos(Map<String, Integer> conteos) {
        if (conteos.isEmpty()) {
            System.out.println("No hay pedidos para contar por tipo.");
        } else {
            System.out.println("Conteo por tipo:");
            for (String tipo : conteos.keySet()) {
                System.out.println("- " + tipo + ": " + conteos.get(tipo));
            }
        }
    }

    // Cierra scanner al terminar
    public void cerrarScanner() {
        scanner.close();
    }
}