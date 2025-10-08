package modelo;

public abstract class Usuario {
    protected String nombre;
    protected String email;
    protected String contrasena;

    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }

    public abstract String getTipo();
}
