import java.util.Vector;

public class Estudiante {
	//Atributos
	private String nombreEstudiante;
	private String apellidoEstudiante;
	private String carrera;
	private int edad;
	private int dni;
	private int creditosAprobados;
	private Vector<String> cursos;
	
	public Estudiante(String nombreEstudiante, String apellidoEstudiante, String carrera, 
			int edad, int dni, int creditosAprobados) {
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.carrera = carrera;
		this.edad = edad;
		this.dni = dni;
		this.creditosAprobados = creditosAprobados;
		cursos = new Vector<>();
		
	}
	
	//Setters y Getters
	public Vector<String> getCursos() {
		return cursos;
	}
	public void setCursos(Vector<String> cursos) {
		this.cursos = cursos;
	}
	public int getCreditosAprobados() {
		return creditosAprobados;
	}
	public void setCreditosAprobados(int creditosAprobados) {
		this.creditosAprobados = creditosAprobados;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}
	public void setApellidoEstudiante(String apellidoEstudiante) {
		this.apellidoEstudiante = apellidoEstudiante;
	}
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	
	
}
