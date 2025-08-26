import java.util.Vector;

public class Curso {
	//Atributos
	private String nombre;
	private int creditos;
	private String docente;
	private int capMaxEstudiantes;
	private Vector <Estudiante> estudiantesInscritos;
	
	private static int totalCursos = 0;
	
	
	public Curso (String nombre, int creditos, String docente, int capMaxEstudiantes) {
		this.nombre = nombre;
		this.creditos = creditos;
		this.docente = docente;
		this.capMaxEstudiantes = capMaxEstudiantes;
		estudiantesInscritos = new Vector<>();
		++totalCursos;
		
	}
	

	public int getCapMaxEstudiantes() {
		return capMaxEstudiantes;
	}
	public void setCapMaxEstudiantes(int capMaxEstudiantes) {
		this.capMaxEstudiantes = capMaxEstudiantes;
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
	
	//Métodos
	
	public void agregarEstudiantes(Estudiante est) {
		
	}
	
	public void removerEstudiante(Estudiante est) {
		
	}
	
	public String toString() {
        return "Información de Curso" + "\n_________________"
                + "\nNombre: " + nombre + " " 
                + "\nCréditos: " + creditos
                + "\nDocente designado: " + docente
                + "\nCapacidad máxima para estudiantes: " + capMaxEstudiantes;
    }
	
	public void mostrarInformacion() {
        System.out.println(toString());
        System.out.println("\nCursos registrados:");
        if (estudiantesInscritos.isEmpty()) {
            System.out.println("No tiene estudiantes inscritos en este curso.");
        } else {
            int i = 1;
            for (Estudiante e : estudiantesInscritos) {
                System.out.println("Estudiante N° " + i + ": " + e.toString());
                i++;
            }
        }		
	}
	
}
