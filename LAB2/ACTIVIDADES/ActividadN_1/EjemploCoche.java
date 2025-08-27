public class EjemploCoche 
{
  public static void main(String[] args) {
    Coche cocheDeportivo = new Coche("Ferrari", "F8", 2022, 250000);
    Coche cocheTodoTerreno = new Coche("Toyota", "Land Cruiser", 2005, 35000);

    cocheDeportivo.encender();
    cocheDeportivo.acelerar();
    cocheDeportivo.frenar();
    cocheDeportivo.apagar();

    System.out.println();
      
    cocheTodoTerreno.encender();
    cocheTodoTerreno.acelerar();
    cocheTodoTerreno.frenar();
    cocheTodoTerreno.apagar();

    System.out.println();

    // Verificar descuento
    cocheDeportivo.aplicarDescuento();
    cocheTodoTerreno.aplicarDescuento();

    // Probar getters y setters
    cocheDeportivo.setPrecio(260000);
    System.out.println("Nuevo precio del Ferrari (con setter): $" + cocheDeportivo.getPrecio());
  }
}
