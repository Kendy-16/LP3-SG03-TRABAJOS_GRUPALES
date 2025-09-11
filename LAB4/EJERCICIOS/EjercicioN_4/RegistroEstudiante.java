import java.util.ArrayList;
import java.util.NoSuchElementException;

//Excepcion Personalizada

class Excepcion_de_blanco extends Exception{
    public Excepcion_de_blanco() {
        super("Excepción de blanco: Espacio en blanco detectado");
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
        ArrayList <Estudiante> estudiantes = new ArrayList<>();
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
        System.out.println("Se agrego a estudiante con exito");
	}
	
	public void buscarEstudiante(Estudiante estudiante) {
	    
	    boolean encontrado = false;
	    try {
	    
    	    for(Estudiante e : estudiantes) {
    	        if(e == estudiante) {
    	            encontrado = true;
    	            System.out.println("El estudiante: " +  estudiante.getNombre() + "fue encontrado");
    	        } 
    	    }
	    } catch (NoSuchElementException o) {
	       System.out.println("(!) El estudiante: " +  estudiante.getNombre() + "no fue encontrado");
            throw new NoSuchElementException ("Error: El valor no puede ser negativo. Valor ingresado: " + estudiante.getNombre());
	    }
	}
}

class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Jose");
        Estudiante estudiante2 = new Estudiante("Laura");
        
        RegistroEstudiante registro = new RegistroEstudiante();
        registro.agregarEstudiante(estudiante1);
    }
}
