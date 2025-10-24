public class Receta {
    private int id;
    private String nombre;
    private String ingredientes;
    private String preparacion;

    public Receta(int id, String nombre, String ingredientes, String preparacion) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public Receta(String nombre, String ingredientes, String preparacion) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getIngredientes() { return ingredientes; }
    public String getPreparacion() { return preparacion; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }
    public void setPreparacion(String preparacion) { this.preparacion = preparacion; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Ingredientes: " + ingredientes + " | Preparación: " + preparacion;
    }
}

