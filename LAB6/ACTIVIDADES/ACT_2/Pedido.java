public class Pedido {
    private String nombrePlato;
    private String tipo;

    // Constructor: crea un pedido con nombre y tipo
    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
    }

    // Devuelve el nombre del plato
    public String getNombrePlato() {
        return nombrePlato;
    }

    // Devuelve el tipo del plato
    public String getTipo() {
        return tipo;
    }

    // Actualiza el nombre del plato
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    // Actualiza el tipo del plato
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}