public class Contacto {
    private String nombre;
    private long fono;
    private String correo;
    
    public Contacto(String nombre, long fono, String correo) {
        this.nombre = nombre;
        this.fono = fono;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getFono() {
        return fono;
    }

    public void setFono(long fono) {
        this.fono = fono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + fono + ", Correo: " + correo;
    }
}
