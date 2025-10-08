package modelo;

import java.util.ArrayList;

public class Carrito {
  
  protected ArrayList <Producto> carrito;
  private static ArrayList<Carrito> carritosActivos = new ArrayList<>();
  
  public Carrito() {
    carrito = new ArrayList<>();
    carritosActivos.add(this);
  }
  
  public ArrayList<Producto> getCarrito() {
    return carrito;
  }
  
  public void agregarProducto(Producto produc) {
    carrito.add(produc);
  }
  
  public void eliminarProducto(String codigo) {
    boolean encontrado = false;
    for (Producto p : carrito) {
        if (p.getIdentificador().equalsIgnoreCase(codigo)) {
            carrito.remove(p);
            System.out.println("Producto eliminado del carrito.");
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        System.out.println("No se encontró un producto con ese código.");
    }
}

  public void vaciarCarrito() {
    carrito.clear();
  }
  
  public double totalPrecio() {
    double total = 0;
    Producto p;
    
    for (int i = 0; i < carrito.size(); i++) {
       p = carrito.get(i);
       
       total += p.getPrecio();
    }
    return total;
  }
  
  @Override
  public String toString() {
    
    if (carrito.isEmpty()) {
      return "El carrito está vacío.";
    }
    
    String lista = "Productos en el carrito:\n__________________________\n";
    System.out.println("__________________________");
    for (int i = 0; i < carrito.size(); i++) {
       lista += (i + 1) + ". " + carrito.get(i).toString() + "\n";
    }
    
    return lista;
  }
  public boolean estaVacio() {
    return carrito.isEmpty();
}


public static void removerDeTodosLosCarritos(String codigo) {
    for (Carrito c : carritosActivos) {
        c.carrito.removeIf(p -> p.getIdentificador().equalsIgnoreCase(codigo));
    }
}

}
