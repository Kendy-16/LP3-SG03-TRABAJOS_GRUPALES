import java.util.ArrayList;
import java.util.NoSuchElementException;

//Excepcion Personalizada

class Excepcion_de_blanco extends Exception {
	public Excepcion_de_blanco() {
		super("(!) Excepcion de blanco: Espacio en blanco detectado");
	}
}

//Clase Estudiante
class Estudiante {
	private String nombre;

	public Estudiante(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

//Clase Registro de estudiantes
class RegistroEstudiante {
	private ArrayList <Estudiante> estudiantes;

	public RegistroEstudiante() {
		estudiantes = new ArrayList<>();
	}

	public ArrayList <Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList <Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public void agregarEstudiante(Estudiante nuevo) throws Excepcion_de_blanco {
		for (int i = 0; i < nuevo.getNombre().length(); i ++) {
			if(nuevo.getNombre().charAt(i) ==  ' ') {
				throw new Excepcion_de_blanco();
			}
		}
		estudiantes.add(nuevo);
		System.out.println("Se agrego a estudiante " + nuevo.getNombre() +" con exito");
	}

	public void buscarEstudiante(Estudiante estudiante) {
        
        boolean encontrado = false;
    
			for(Estudiante e : estudiantes) {
				if(e.getNombre().equals(estudiante.getNombre())) {
				    encontrado = true;
					System.out.println("El estudiante: " +  estudiante.getNombre() + " fue encontrado");
					break;
				}
			}
			
            if (!encontrado) {
                throw new NoSuchElementException("\n(!) Estudiante " + estudiante.getNombre() + " NO fue encontrado");
            }
	}
	
}

class Main {
	public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Jose");
        Estudiante estudiante2 = new Estudiante("Laura");
        Estudiante estudiante3 = new Estudiante(" "); 
        Estudiante estudiante4 = new Estudiante("Fernando");


		RegistroEstudiante registro = new RegistroEstudiante();

		try {
            registro.agregarEstudiante(estudiante1);  
            registro.agregarEstudiante(estudiante2);  
            registro.agregarEstudiante(estudiante3);  


		} catch (Excepcion_de_blanco e) {

			System.out.println("Error al agregar a estudiante\n" + e.getMessage());

		}
		
        try {
            
            registro.buscarEstudiante(estudiante3);  
            
        } catch (NoSuchElementException e) {
            
            System.out.println("Error al buscar estudiante "+ e.getMessage());
            
        }
	}
}
