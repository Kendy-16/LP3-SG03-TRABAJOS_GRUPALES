import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;

    // Inicializa la lista de pedidos
    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    // Agrega un pedido a la lista
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Devuelve la lista de pedidos
    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
