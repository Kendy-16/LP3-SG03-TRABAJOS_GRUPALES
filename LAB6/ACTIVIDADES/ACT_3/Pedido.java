public class Pedido {
    private String nombrePlato;
    private String tipo;
    private boolean completado; // true si ya fue servido
    private boolean eliminado;  // true si fue eliminado

    // Constructor con nombre y tipo; al crearse está pendiente (no completado ni eliminado)
    public Pedido(String nombrePlato, String tipo) {
        this.nombrePlato = nombrePlato;
        this.tipo = tipo;
        this.completado = false;
        this.eliminado = false;
    }

    // Getters y setters
    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Marca como completado (y asegura no estar eliminado)
    public void marcarCompletado() {
        this.completado = true;
        this.eliminado = false;
    }

    // Marca como eliminado (y asegura no estar completado)
    public void marcarEliminado() {
        this.eliminado = true;
        this.completado = false;
    }
}
