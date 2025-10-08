package modelo;
import java.util.ArrayList;

public class HistorialCompras {

    // Lista que guarda todos los carritos comprados
    private ArrayList<Carrito> compras = new ArrayList<>();

    // Registrar una compra (guardar el carrito actual)
    public void registrarCompra(Carrito carrito) {
        // Creamos una copia del carrito actual para no perder los datos
        Carrito copia = new Carrito();
        for (Producto p : carrito.getCarrito()) {
            copia.agregarProducto(p);
        }
        compras.add(copia);
        System.out.println("Compra registrada en el historial.");
    }

    public void mostrarHistorial() {
    if (compras.isEmpty()) {
        System.out.println("No hay compras registradas.");
    } else {
        System.out.println("\nHISTORIAL DE COMPRAS\n__________________________");
        for (int i = 0; i < compras.size(); i++) {
            System.out.println("Compra #" + (i + 1) + ":");
            historialCompras(compras.get(i)); 
            System.out.println("-----------------------------");
        }
    }
}


    // Método que imprime los productos del carrito (mantiene tu idea original)
    public void historialCompras(Carrito carrito) {
        ArrayList<Producto> lista = carrito.getCarrito();

        System.out.println("Productos comprados:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).toString());
        }
    }
}
