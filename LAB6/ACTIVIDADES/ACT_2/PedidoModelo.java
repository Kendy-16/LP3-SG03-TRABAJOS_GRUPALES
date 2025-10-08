import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    // Agrega un pedido a la lista
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Elimina un pedido por índice (si es válido)
    public boolean eliminarPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.remove(indice);
            return true;
        }
        return false;
    }

    // Actualiza nombre y/o tipo de un pedido por índice
    public boolean actualizarPedido(int indice, String nuevoNombre, String nuevoTipo) {
        if (indice >= 0 && indice < pedidos.size()) {
            Pedido p = pedidos.get(indice);
            if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                p.setNombrePlato(nuevoNombre);
            }
            if (nuevoTipo != null && !nuevoTipo.isEmpty()) {
                p.setTipo(nuevoTipo);
            }
            return true;
        }
        return false;
    }

    // Devuelve la lista de pedidos
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // Busca pedidos cuyo nombre contenga la cadena (no distingue mayúsc/min)
    public List<Pedido> buscarPorNombre(String nombre) {
        List<Pedido> encontrados = new ArrayList<>();
        String criterio = nombre.toLowerCase();
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().toLowerCase().contains(criterio)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    // Busca pedidos por tipo exacto (sin distinguir mayús/minús)
    public List<Pedido> buscarPorTipo(String tipo) {
        List<Pedido> encontrados = new ArrayList<>();
        String criterio = tipo.toLowerCase();
        for (Pedido p : pedidos) {
            if (p.getTipo().toLowerCase().equals(criterio)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    // Retorna el conteo total de pedidos
    public int contarPedidos() {
        return pedidos.size();
    }

    // Retorna un mapa con conteo por tipo
    public Map<String, Integer> contarPorTipos() {
        Map<String, Integer> conteos = new HashMap<>();
        for (Pedido p : pedidos) {
            String tipo = p.getTipo();
            Integer val = conteos.get(tipo);
            if (val == null) {
                conteos.put(tipo, 1);
            } else {
                conteos.put(tipo, val + 1);
            }
        }
        return conteos;
    }
}