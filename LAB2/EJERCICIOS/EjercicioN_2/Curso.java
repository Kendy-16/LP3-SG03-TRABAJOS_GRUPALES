package SistemaCursoUniversitario;

public class Curso {
	//Atributos
	private String nombre;
	private int creditos;
	private String docente;
	private int capMaxEstudiantes;
	private int estudiantesInscritos;
	
	
	public Curso (String nombre, int creditos, String docente, int capMaxEstudiantes, int estudiantseInscritos) {
		this.nombre = nombre;
	}
	
	public int getEstudiantesInscritos() {
		return estudiantesInscritos;
	}
	public void setEstudiantesInscritos(int estudiantesInscritos) {
		this.estudiantesInscritos = estudiantesInscritos;
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
	
	
}
