public class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return String.format("Número: %d | Nombre: %-15s | Sueldo: $%,.2f", 
                           numero, nombre, sueldo);
    }

    // Método para formato de archivo
    public String toFileFormat() {
        return numero + "|" + nombre + "|" + sueldo;
    }
}
