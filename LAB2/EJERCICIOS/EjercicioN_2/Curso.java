
//Curso.java
import java.util.Vector;

public class Curso {
	//Atributos
	private String nombre;
	private int creditos;
	private String docente;
	private final int capMaxEstudiantes = 16;
	private Vector <Estudiante> estudiantesInscritos;
	
	private static int totalCursos = 0;
	
	public Curso (String nombre, int creditos) {
		this.nombre = nombre;
		this.creditos = creditos;
		setEstudiantesInscritos(new Vector<>());
		++totalCursos;
		
	}


	public int getCapMaxEstudiantes() {
		return capMaxEstudiantes;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private Vector <Estudiante> getEstudiantesInscritos() {
		return estudiantesInscritos;
	}

	private void setEstudiantesInscritos(Vector <Estudiante> estudiantesInscritos) {
		this.estudiantesInscritos = estudiantesInscritos;
	}	

	//Métodos
	
	public void agregarEstudiantes(Estudiante est) {
	    if (!estudiantesInscritos.contains(est)) { 
	    	estudiantesInscritos.add(est);
	        System.out.println("Se agregó al estudiante: " 
	                           + est.getNombre() + " " 
	                           + est.getApellido() 
	                           + " al curso " + nombre);
	    } else {
	        System.out.println("El estudiante ya está inscrito en este curso.");
	    }
	}

	public void removerEstudiante(Estudiante est) {
	    if (estudiantesInscritos.contains(est)) {
	    	estudiantesInscritos.remove(est);
	        System.out.println("Se removió al estudiante: " 
	                           + est.getNombre() + " " 
	                           + est.getApellido() 
	                           + " del curso " + nombre);
	    } else {
	        System.out.println("El estudiante no está inscrito en este curso.");
	    }
	}

	
	public String toString() {
        return "\n_________________"
                + "\nNombre: " + nombre + " " 
                + "\nCréditos: " + creditos
                + "\nDocente designado: " + docente
                + "\nCapacidad máxima para estudiantes: " + capMaxEstudiantes;
    }
	
	public void mostrarInformacion() {
        System.out.println(toString());
        System.out.println("\nCursos registrados:");
        if (getEstudiantesInscritos().isEmpty()) {
            System.out.println("No tiene estudiantes inscritos en este curso.");
        } else {
            int i = 1;
            for (Estudiante e : getEstudiantesInscritos()) {
                System.out.println("Estudiante N° " + i + ": " + e.toString());
                i++;
            }
        }		
	}

	
}

