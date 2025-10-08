package modelo;

public class Administrador extends Usuario {
    public Administrador(String nombre, String email, String contrasena) {
        super(nombre, email, contrasena);
    }

    @Override
    public String getTipo() { return "Administrador"; }
}
