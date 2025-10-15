import java.io.Serializable;

public class Alumno extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private Fecha fechaMatricula;

    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        super(nif, nombre, edad);
        this.fechaMatricula = new Fecha();
        setFechaMatricula(fechaMatricula);
    }

    public Alumno() {
        super();
    }

    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Fecha fechaMatricula) {
        if (fechaMatricula == null) {
            this.fechaMatricula = null;
            return;
        }
        // copia los valores para evitar aliasing
        if (this.fechaMatricula == null) {
            this.fechaMatricula = new Fecha();
        }
        this.fechaMatricula.setDia(fechaMatricula.getDia());
        this.fechaMatricula.setMes(fechaMatricula.getMes());
        this.fechaMatricula.setAnio(fechaMatricula.getAnio());
    }

    @Override
    public String toString() {
        return super.toString() + ", FechaMatricula=" + (fechaMatricula != null ? fechaMatricula : "null");
    }
}
