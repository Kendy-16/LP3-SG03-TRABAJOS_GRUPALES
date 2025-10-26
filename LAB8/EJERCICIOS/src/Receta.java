public class Receta {
    private int id;
    private String titulo;
    private String descripcion;
    private int tiempoPreparacion;
    private int tiempoCoccion;
    private String instrucciones;

    public Receta(int id, String titulo, String descripcion, int tiempoPreparacion, int tiempoCoccion, String instrucciones) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tiempoPreparacion = tiempoPreparacion;
        this.tiempoCoccion = tiempoCoccion;
        this.instrucciones = instrucciones;
    }

    public Receta(String titulo, String descripcion, int tiempoPreparacion, int tiempoCoccion, String instrucciones) {
        this(0, titulo, descripcion, tiempoPreparacion, tiempoCoccion, instrucciones);
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public int getTiempoPreparacion() { return tiempoPreparacion; }
    public int getTiempoCoccion() { return tiempoCoccion; }
    public String getInstrucciones() { return instrucciones; }
}

