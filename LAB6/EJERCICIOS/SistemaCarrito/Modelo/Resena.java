package modelo;

public class Resena {
    private Usuario usuario;
    private Producto producto;
    private int calificacion; // 1-5
    private String comentario;

    public Resena(Usuario usuario, Producto producto, int calificacion, String comentario) {
        this.usuario = usuario;
        this.producto = producto;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public void mostrarResena() {
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Calificación: " + calificacion + "★");
        System.out.println("Comentario: " + comentario + "\n");
    }
}
