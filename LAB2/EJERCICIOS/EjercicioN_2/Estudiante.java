
import java.util.Vector;

public class Estudiante {
	//Atributos
	private String nombreEstudiante;
	private String apellidoEstudiante;
	private String carrera;
	private int edad;
	private int dni;
	private int creditosAprobados;
	private double promedioGeneral;
	private Vector<Curso> cursos;
	
	//Atributos de clase
	private static int contadorEstudiantes = 0;
	
	
	public Estudiante(String nombreEstudiante, String apellidoEstudiante, String carrera, 
			int edad, int dni, int creditosAprobados, double promedioGeneral) {
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.carrera = carrera;
		this.edad = edad;
		this.dni = dni;
		this.creditosAprobados = creditosAprobados;
		this.setPromedioGeneral(promedioGeneral);
		cursos = new Vector<>();
        contadorEstudiantes++;

		
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

	public double getPromedioGeneral() {
		return promedioGeneral;
	}

	public void setPromedioGeneral(double promedioGeneral) {
		this.promedioGeneral = promedioGeneral;
	}
	
    // Métodos
    public void inscribirseCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            System.out.println(nombreEstudiante + " se inscribió en el curso: " + curso.getNombreCurso());
        } else {
            System.out.println("El estudiante ya está inscrito en este curso.");
        }
    }

    @Override
    public String toString() {
        return "Información del Estudiante" + "\n_________________"
                + "\nNombre: " + nombreEstudiante + " " + apellidoEstudiante
                + "\nCarrera: " + carrera
                + "\nEdad: " + edad
                + "\nDNI: " + dni
                + "\nCréditos Aprobados: " + creditosAprobados
                + "\nPromedio General: " + promedioGeneral;
    }

    public void mostrarInformacion() {
        System.out.println(toString());
        System.out.println("\nCursos inscritos:");
        if (cursos.isEmpty()) {
            System.out.println("No tiene cursos inscritos.");
        } else {
            int i = 1;
            for (Curso c : cursos) {
                System.out.println("Curso N° " + i + ": " + c.toString());
                i++;
            }
        }
    }
	
	
}

