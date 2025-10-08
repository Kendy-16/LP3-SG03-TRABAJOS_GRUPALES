import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // Solicita nombre del plato
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    // Solicita tipo del plato
    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo del plato (Entrada, Principal, Postre, etc): ");
        return scanner.nextLine();
    }

    // Solicita índice (para pendientes)
    public int solicitarIndicePendiente() {
        System.out.print("Introduce el índice del pedido pendiente: ");
        int idx = -1;
        try {
            idx = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // si falla, devolvemos -1 y el controlador lo manejará como índice inválido
            idx = -1;
        }
        return idx;
    }

    // Muestra lista de pendientes con índice
    public void mostrarPedidosPendientes(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Pedidos pendientes:");
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido p = pedidos.get(i);
                System.out.println(i + ". " + p.getNombrePlato() + " (Tipo: " + p.getTipo() + ")");
            }
        }
    }

    // Muestra lista de completados (historial)
    public void mostrarHistorialCompletados(List<Pedido> completados) {
        if (completados.isEmpty()) {
            System.out.println("No hay pedidos completados aún.");
        } else {
            System.out.println("Historial de pedidos completados:");
            for (int i = 0; i < completados.size(); i++) {
                Pedido p = completados.get(i);
                System.out.println(i + ". " + p.getNombrePlato() + " (Tipo: " + p.getTipo() + ")");
            }
        }
    }

    // Muestra historial de eliminados
    public void mostrarHistorialEliminados(List<Pedido> eliminados) {
        if (eliminados.isEmpty()) {
            System.out.println("No hay pedidos eliminados.");
        } else {
            System.out.println("Historial de pedidos eliminados:");
            for (int i = 0; i < eliminados.size(); i++) {
                Pedido p = eliminados.get(i);
                System.out.println(i + ". " + p.getNombrePlato() + " (Tipo: " + p.getTipo() + ")");
            }
        }
    }

    // Muestra menú con las nuevas opciones
    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos Pendientes");
        System.out.println("3. Marcar Pedido como Completo");
        System.out.println("4. Eliminar Pedido");
        System.out.println("5. Actualizar Pedido (pendiente)");
        System.out.println("6. Mostrar Pedidos Completados (historial)");
        System.out.println("7. Mostrar Pedidos Eliminados (historial)");
        System.out.println("8. Contador de Pedidos Pendientes");
        System.out.println("9. Salir");
    }

    // Solicita opción
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    // Mensaje simple
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Cierra scanner
    public void cerrarScanner() {
        scanner.close();
    }
}