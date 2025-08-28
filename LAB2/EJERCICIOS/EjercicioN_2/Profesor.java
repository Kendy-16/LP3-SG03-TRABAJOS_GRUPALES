
//Profesor.java
import java.util.Vector;

public class Profesor extends Persona {
    private String especialidad;
    private Vector<Curso> cursos;

    public Profesor(String nombre, String apellido, int dni, String especialidad) {
        super(nombre, apellido, dni);
        this.setEspecialidad(especialidad);
        cursos = new Vector<>();
    }

    public void asignarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            System.out.println(nombre + " tiene asignado el curso: " + curso.getNombre());
        } else {
            System.out.println("El docente ya tiene asignado este curso.");
        }
    }

    public Vector<Curso> getCursos() {
		return cursos;
	}

    public void setCursos(Vector<Curso> cursos) {
		this.cursos = cursos;
	}

    public String getEspecialidad() {
		return especialidad;
	}

    public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor: " + nombre + " " + apellido);
        System.out.println("Especialidad: " + getEspecialidad());
    }
}
