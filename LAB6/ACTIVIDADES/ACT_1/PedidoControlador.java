import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    // Constructor: recibe referencias al modelo y a la vista
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Lógica para agregar un pedido (valida que no esté vacío)
    public void agregarPedido(String nombrePlato) {
        if (!nombrePlato.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
        } else {
            vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
        }
    }

    // Pide al modelo la lista de pedidos y la muestra desde la vista
    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    // Bucle principal que muestra el menú y atiende las opciones
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    agregarPedido(nombrePlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("3"));
        vista.cerrarScanner();
    }
}