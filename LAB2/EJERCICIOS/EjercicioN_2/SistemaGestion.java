
//SistemaGestion.java
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class SistemaGestion {
	private ArrayList <Estudiante> estudiantes;
	private ArrayList <Profesor> profesores;
	private ArrayList <Curso> cursos;

	
	public SistemaGestion() {
		
		estudiantes = new ArrayList<>();
		profesores = new ArrayList<>();
		cursos = new ArrayList<>();

		
		//Scanner entrada = new Scanner(System.in);
	}

	//Getters y setters
	
	//Métodos
    public void registrarEstudiante() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n--- Registrar Estudiante ---");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Apellido: ");
        String apellido = entrada.nextLine();

        System.out.print("DNI: ");
        int dni = entrada.nextInt();
        entrada.nextLine(); // limpiar buffer


        System.out.print("Carrera: ");
        String carrera = entrada.nextLine();

        System.out.print("Edad: ");
        int edad = entrada.nextInt();

        System.out.print("Créditos aprobados: ");
        int creditos = entrada.nextInt();

        System.out.print("Promedio general: ");
        double promedio = entrada.nextDouble();

        Estudiante nuevo = new Estudiante(nombre, apellido, dni, carrera, edad, creditos, promedio);
        estudiantes.add(nuevo);

        System.out.println("Estudiante registrado correctamente.");
    }
		

    public void registrarProfesor() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n--- Registrar Profesor ---");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Apellido: ");
        String apellido = entrada.nextLine();

        System.out.print("DNI: ");
        int dni = entrada.nextInt();
        entrada.nextLine(); // limpiar buffer

        System.out.print("Especialidad: ");
        String especialidad = entrada.nextLine();

        Profesor nuevo = new Profesor(nombre, apellido, dni, especialidad);
        profesores.add(nuevo);

        System.out.println("Profesor registrado correctamente.");
    }

    public void registrarCurso() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n--- Registrar Curso ---");
        System.out.print("Nombre del curso: ");
        String nombre = entrada.nextLine();

        System.out.print("Créditos: ");
        int creditos = entrada.nextInt();
        entrada.nextLine(); // limpiar buffer


        Curso nuevo = new Curso(nombre, creditos);
        cursos.add(nuevo);

        System.out.println("Curso registrado correctamente.");
    }

	public void mostrarCursosDisponibles() {
	    System.out.println("____________________\nLista de cursos en el Sistema\n______________________");
	    
	    if (cursos.isEmpty()) {
	        System.out.println("No hay cursos registrados.");
	    } else {
	        int i = 1; 
	        for (Curso c : cursos) {
	            System.out.println("Cursos N° " + i + ": " + c.toString());
	    	    System.out.println("_______________________________");

	            i++;
	        
	        }
	    }
		
	}

	public void mostrarListaEstudiantes() {
	    System.out.println("____________________\nLista de estudiantes\n______________________");
	    
	    if (estudiantes.isEmpty()) {
	        System.out.println("No hay estudiantes registrados.");
	    } else {
	        int i = 1; 
	        for (Estudiante e : estudiantes) {
	            System.out.println("Estudiante N° " + i + ": " + e.datosBasicos());
	            i++;
	        }
	    }
	}


	public void mostrarProfesores() {
	    System.out.println("____________________\nLista de profesores en el Sistema\n______________________");
	    
	    if (profesores.isEmpty()) {
	        System.out.println("No hay profesores registrados.");
	    } else {
	        int i = 1; 
	        for (Profesor p : profesores) {
	            System.out.println("Profesor/a N° " + i + ": " + p.toString());
	    	    System.out.println("_______________________________");

	            i++;
	        
	        }
	    }
		
	}

	
	//Getters y Setters
	public ArrayList <Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList <Curso> cursos) {
		this.cursos = cursos;
	}

	public ArrayList <Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList <Profesor> profesores) {
		this.profesores = profesores;
	}

	public ArrayList <Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList <Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
