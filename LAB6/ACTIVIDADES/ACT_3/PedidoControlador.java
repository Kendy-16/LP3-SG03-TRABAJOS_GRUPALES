import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Agregar nuevo pedido (va a pendientes)
    public void agregarPedido(String nombrePlato, String tipo) {
        if (nombrePlato == null || nombrePlato.trim().isEmpty()) {
            vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
            return;
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            vista.mostrarMensaje("El tipo del plato no puede estar vacío.");
            return;
        }
        modelo.agregarPedido(new Pedido(nombrePlato.trim(), tipo.trim()));
        vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (Tipo: " + tipo + ")");
    }

    // Mostrar pedidos pendientes
    public void mostrarPendientes() {
        List<Pedido> pendientes = modelo.getPedidosPendientes();
        vista.mostrarPedidosPendientes(pendientes);
    }

    // Marcar un pedido pendiente como completado
    public void marcarCompletado() {
        mostrarPendientes();
        int idx = vista.solicitarIndicePendiente();
        if (idx < 0) {
            vista.mostrarMensaje("Índice inválido.");
            return;
        }
        boolean ok = modelo.completarPedido(idx);
        if (ok) {
            vista.mostrarMensaje("Pedido marcado como completado y movido al historial.");
        } else {
            vista.mostrarMensaje("Índice inválido. No se completó ningún pedido.");
        }
    }

    // Eliminar un pedido pendiente (mover a historial de eliminados)
    public void eliminarPedido() {
        mostrarPendientes();
        int idx = vista.solicitarIndicePendiente();
        if (idx < 0) {
            vista.mostrarMensaje("Índice inválido.");
            return;
        }
        boolean ok = modelo.eliminarPedido(idx);
        if (ok) {
            vista.mostrarMensaje("Pedido eliminado y movido al historial de eliminados.");
        } else {
            vista.mostrarMensaje("Índice inválido. No se eliminó ningún pedido.");
        }
    }

    // Actualizar un pedido pendiente
    public void actualizarPedido() {
        mostrarPendientes();
        int idx = vista.solicitarIndicePendiente();
        if (idx < 0) {
            vista.mostrarMensaje("Índice inválido.");
            return;
        }
        vista.mostrarMensaje("Dejar vacío para no cambiar un campo.");
        String nuevoNombre = vista.solicitarNombrePlato();
        String nuevoTipo = vista.solicitarTipoPlato();
        boolean ok = modelo.actualizarPedido(idx, nuevoNombre, nuevoTipo);
        if (ok) {
            vista.mostrarMensaje("Pedido actualizado en pendientes.");
        } else {
            vista.mostrarMensaje("Índice inválido. No se actualizó ningún pedido.");
        }
    }

    // Mostrar historial de completados
    public void mostrarHistorialCompletados() {
        List<Pedido> completados = modelo.getHistorialCompletados();
        vista.mostrarHistorialCompletados(completados);
    }

    // Mostrar historial de eliminados
    public void mostrarHistorialEliminados() {
        List<Pedido> eliminados = modelo.getHistorialEliminados();
        vista.mostrarHistorialEliminados(eliminados);
    }

    // Mostrar contador de pendientes
    public void mostrarContadorPendientes() {
        int total = modelo.contarPendientes();
        vista.mostrarMensaje("Pedidos pendientes en total: " + total);
    }

    // Bucle principal
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    String tipo = vista.solicitarTipoPlato();
                    agregarPedido(nombre, tipo);
                    break;
                case "2":
                    mostrarPendientes();
                    break;
                case "3":
                    marcarCompletado();
                    break;
                case "4":
                    eliminarPedido();
                    break;
                case "5":
                    actualizarPedido();
                    break;
                case "6":
                    mostrarHistorialCompletados();
                    break;
                case "7":
                    mostrarHistorialEliminados();
                    break;
                case "8":
                    mostrarContadorPendientes();
                    mostrarPendientes();
                    break;
                case "9":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("9"));
        vista.cerrarScanner();
    }
}
