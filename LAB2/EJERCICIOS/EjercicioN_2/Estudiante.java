
import java.util.Vector;

//Estudiante.java
import java.util.Vector;

public class Estudiante extends Persona {
	//Atributos

	private String carrera;
	private int edad;
	private int creditosAprobados;
	private double promedioGeneral;
	private Vector<Curso> cursos;
	private Vector <String> listaEstudiantes;
	
	//Atributos de clase
	private static int contadorEstudiantes = 0;
	
	
	public Estudiante(String nombre, String apellido, int dni,  String carrera, 
			int edad, int creditosAprobados, double promedioGeneral) {
		
		super(nombre, apellido, dni);
		
		this.carrera = carrera;
		this.edad = edad;
		this.creditosAprobados = creditosAprobados;
		this.setPromedioGeneral(promedioGeneral);
		cursos = new Vector<>();
		listaEstudiantes = new Vector<>();
        contadorEstudiantes++;

		
	}
	
	//Setters y Getters
	public Vector<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Vector<Curso> cursos) {
		this.cursos = cursos;
	}
	public int getCreditosAprobados() {
		return creditosAprobados;
	}
	public void setCreditosAprobados(int creditosAprobados) {
		this.creditosAprobados = creditosAprobados;
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
            System.out.println(nombre + " se inscribió en el curso: " + curso.getNombre());
        } else {
            System.out.println("El estudiante ya está inscrito en este curso.");
        }

    }
    
    public void registrarDatosEstudiantes() {
    	
    }

    @Override
    public String toString() {
        return "Información del Estudiante" + "\n_________________"
                + "\nNombre: " + nombre + " " + apellido
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
    
    public String datosBasicos() {
        return("\nNombre:"+nombre+"\nApellidos: "+apellido);

    }
	
}
