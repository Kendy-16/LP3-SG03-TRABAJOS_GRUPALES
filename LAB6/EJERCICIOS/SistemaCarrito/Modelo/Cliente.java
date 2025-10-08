package modelo;

public class Cliente extends Usuario {
    public Cliente(String nombre, String email, String contrasena) {
        super(nombre, email, contrasena);
    }

    @Override
    public String getTipo() { return "Cliente"; }
}
