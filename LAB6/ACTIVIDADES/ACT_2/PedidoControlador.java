import java.util.List;
import java.util.Map;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Agrega pedido validando campos
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

    // Mostrar pedidos
    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    // Eliminar pedido por índice
    public void eliminarPedido(int indice) {
        boolean ok = modelo.eliminarPedido(indice);
        if (ok) {
            vista.mostrarMensaje("Pedido eliminado en índice " + indice);
        } else {
            vista.mostrarMensaje("Índice inválido. No se eliminó ningún pedido.");
        }
    }

    // Actualizar pedido por índice (si cadena vacía, no actualiza ese campo)
    public void actualizarPedido(int indice, String nuevoNombre, String nuevoTipo) {
        boolean ok = modelo.actualizarPedido(indice, nuevoNombre, nuevoTipo);
        if (ok) {
            vista.mostrarMensaje("Pedido actualizado en índice " + indice);
        } else {
            vista.mostrarMensaje("Índice inválido. No se actualizó ningún pedido.");
        }
    }

    // Buscar por nombre
    public void buscarPorNombre(String nombre) {
        List<Pedido> encontrados = modelo.buscarPorNombre(nombre);
        vista.mostrarPedidosEncontrados(encontrados);
    }

    // Buscar por tipo
    public void buscarPorTipo(String tipo) {
        List<Pedido> encontrados = modelo.buscarPorTipo(tipo);
        vista.mostrarPedidosEncontrados(encontrados);
    }

    // Contar pedidos total y por tipos
    public void contarPedidos() {
        int total = modelo.contarPedidos();
        Map<String, Integer> conteos = modelo.contarPorTipos();
        vista.mostrarConteoTotal(total);
        vista.mostrarConteoPorTipos(conteos);
    }

    // Bucle principal con menú ampliado
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
                    mostrarPedidos();
                    break;
                case "3":
                    mostrarPedidos();
                    int idxEliminar = vista.solicitarIndice();
                    eliminarPedido(idxEliminar);
                    break;
                case "4":
                    mostrarPedidos();
                    int idxActualizar = vista.solicitarIndice();
                    vista.mostrarMensaje("Dejar vacío para no cambiar un campo.");
                    String nuevoNombre = vista.solicitarNombrePlato();
                    String nuevoTipo = vista.solicitarTipoPlato();
                    // si el usuario deja vacío las cadenas, el modelo no cambia ese campo
                    actualizarPedido(idxActualizar, nuevoNombre, nuevoTipo);
                    break;
                case "5":
                    vista.mostrarMensaje("Buscar por: 1 = Nombre, 2 = Tipo");
                    String optBuscar = vista.solicitarOpcion();
                    if ("1".equals(optBuscar)) {
                        String termino = vista.solicitarNombrePlato();
                        buscarPorNombre(termino);
                    } else if ("2".equals(optBuscar)) {
                        String termino = vista.solicitarTipoPlato();
                        buscarPorTipo(termino);
                    } else {
                        vista.mostrarMensaje("Opción de búsqueda no válida.");
                    }
                    break;
                case "6":
                    contarPedidos();
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("7"));
        vista.cerrarScanner();
    }
}