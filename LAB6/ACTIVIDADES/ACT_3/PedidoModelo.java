import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    // pedidos: lista de pedidos pendientes (no completados ni eliminados)
    private List<Pedido> pedidos;
    // historiales para completados y eliminados
    private List<Pedido> historialCompletados;
    private List<Pedido> historialEliminados;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historialCompletados = new ArrayList<>();
        historialEliminados = new ArrayList<>();
    }

    // Agregar pedido (va a la lista de pendientes)
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Completar pedido: marca, lo saca de pendientes y lo agrega al historial de completados
    public boolean completarPedido(int indicePendiente) {
        if (indicePendiente >= 0 && indicePendiente < pedidos.size()) {
            Pedido p = pedidos.get(indicePendiente);
            p.marcarCompletado();
            // mover a historial
            historialCompletados.add(p);
            pedidos.remove(indicePendiente);
            return true;
        }
        return false;
    }

    // Eliminar pedido: marca eliminado, lo saca de pendientes y lo agrega al historial de eliminados
    public boolean eliminarPedido(int indicePendiente) {
        if (indicePendiente >= 0 && indicePendiente < pedidos.size()) {
            Pedido p = pedidos.get(indicePendiente);
            p.marcarEliminado();
            historialEliminados.add(p);
            pedidos.remove(indicePendiente);
            return true;
        }
        return false;
    }

    // Actualizar un pedido dentro de pendientes (nombre y/o tipo)
    public boolean actualizarPedido(int indicePendiente, String nuevoNombre, String nuevoTipo) {
        if (indicePendiente >= 0 && indicePendiente < pedidos.size()) {
            Pedido p = pedidos.get(indicePendiente);
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                p.setNombrePlato(nuevoNombre.trim());
            }
            if (nuevoTipo != null && !nuevoTipo.trim().isEmpty()) {
                p.setTipo(nuevoTipo.trim());
            }
            return true;
        }
        return false;
    }

    // Obtener lista de pendientes
    public List<Pedido> getPedidosPendientes() {
        return pedidos;
    }

    // Obtener historial de completados
    public List<Pedido> getHistorialCompletados() {
        return historialCompletados;
    }

    // Obtener historial de eliminados
    public List<Pedido> getHistorialEliminados() {
        return historialEliminados;
    }

    // Contadores
    public int contarPendientes() {
        return pedidos.size();
    }
}
