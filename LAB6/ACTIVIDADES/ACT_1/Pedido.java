public class Pedido {
    private String nombrePlato;

    // Constructor: crea un pedido con el nombre del plato
    public Pedido(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    // Devuelve el nombre del plato
    public String getNombrePlato() {
        return nombrePlato;
    }
}
