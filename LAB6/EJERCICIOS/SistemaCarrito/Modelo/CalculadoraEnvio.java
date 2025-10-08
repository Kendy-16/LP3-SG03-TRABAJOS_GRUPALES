package modelo;
public class CalculadoraEnvio {
    
    public String direccion;
    
    public CalculadoraEnvio() {
      this.direccion = direccion;
    }
    
  public double calcularCosto(Carrito carrito, String direccion) {
    
    double costoBase = 5;
    double pesoTotal = 0;
    
    for(int i = 0; i < carrito.carrito.size(); i++) {
      Producto p = carrito.carrito.get(i);
      pesoTotal += p.getPeso();
    }
    
    double costoEnvio = costoBase + (pesoTotal * 3.0);

    System.out.println("Destino: " + direccion);
    System.out.println("Peso total: " + pesoTotal + " kg");
    System.out.println("Costo de envío: S/ " + costoEnvio);
    
    return costoEnvio;

  }

}
