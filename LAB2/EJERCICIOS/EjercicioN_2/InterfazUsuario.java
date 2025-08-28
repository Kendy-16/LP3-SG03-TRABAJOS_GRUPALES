
//InterfazUsuario.java
import java.util.Scanner;

public class InterfazUsuario {

	public static void main(String[] args) {
	        Scanner entrada = new Scanner(System.in);
	        SistemaGestion sistema = new SistemaGestion();
	        Estudiante estudiante1 = new Estudiante("Jorge", "Benavente", 61234562, "Medicina Humana", 20, 21, 16.5);
	        Estudiante estudiante2 = new Estudiante("Laura", "Perez", 65434462, "Veterinaria", 25, 21, 19.5);

	        Profesor profesor1 = new Profesor("Manuel", "Zuñiga", 0123431, "Sistemas de Información");
	        Curso curso1 = new Curso("Calculo Integral", 2);
	        		
	        int opcion;

	        do {
	            System.out.println("\n===== Sistema de Gestión Universitaria =====");
	            System.out.println("1. Registrar estudiante");
	            System.out.println("2. Registrar profesor");
	            System.out.println("3. Registrar curso");
	            System.out.println("4. Mostrar lista de estudiantes");
	            System.out.println("5. Mostrar lista de profesores");
	            System.out.println("6. Mostrar lista de cursos");
	            System.out.println("0. Salir");
	            System.out.print("Seleccione una opción: ");

	            opcion = entrada.nextInt();
	            entrada.nextLine(); // limpiar buffer

	            switch (opcion) {
	                case 1:

	                    sistema.registrarEstudiante();
	                    break;

	                case 2:
	                    // Similar para profesor
	                    sistema.registrarProfesor();
	                    break;

	                case 3:
	                    sistema.registrarCurso();
	                    break;

	                case 4:
	                    sistema.mostrarListaEstudiantes();
	                    break;

	                case 5:
	                    // Mostrar profesores
	                    sistema.mostrarProfesores();
	                    break;

	                case 6:
	                    sistema.mostrarCursosDisponibles();;
	                    break;

	                case 0:
	                    System.out.println("Saliendo del sistema...");
	                    break;

	                default:
	                    System.out.println("Opción no válida. Intente nuevamente.");
	            }

	        } while (opcion != 0);

	        entrada.close();
	    }

}
