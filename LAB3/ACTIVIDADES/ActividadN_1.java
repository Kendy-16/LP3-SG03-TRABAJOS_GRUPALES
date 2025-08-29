public abstract class VehiculoConMotor {
    public boolean encendido;
    
    public VehiculoConMotor(boolean encendido) {
        this.encendido = encendido;
    }
    
    public abstract boolean encender();
    public abstract void acelerar();
    
}
public abstract class VehiculoSinMotor {
    
    public boolean pedalear;
    
    public VehiculoSinMotor (boolean pedalear) {
        this.pedalear = pedalear;
    }
    
    public abstract void acelerar();
    
}
public class Carro extends VehiculoConMotor {
    public String nombre;
    public int numPuertas;
    
    public Carro(boolean encendido, String nombre, int numPuertas) {
        
        super(encendido);
        this.nombre = nombre;
        this.numPuertas = numPuertas;
    }
    
    @Override
    public boolean encender() {
        encendido = true;
        return encendido;
    }
    
    @Override
    public void acelerar() {
        if(!encendido) {
            System.out.println("No se puede encender el carro: "+nombre);
        }
        else {
            System.out.println("El carro : "+nombre + " esta acelerando");

        }
    }

  public class Bicicleta extends VehiculoSinMotor{
    public int numRuedas;
    public String marca;
    
    public Bicicleta(boolean pedalear, int numRuedas, String marca) {
        super(pedalear);
        this.numRuedas = numRuedas;
        this.marca = marca;
    }
    
    @Override
    public void acelerar() {
            System.out.println("La Bicicleta: "+ marca +" esta avanzando");
    }
}
public class Main{
    
	public static void main(String[] args) {
		
		Bicicleta bicicleta_1 = new Bicicleta(true, 2, "Ty-6");
		bicicleta_1.acelerar();
		
		Carro carro_1 = new Carro(false, "Toyota", 4);
		carro_1.encender();
		carro_1.acelerar();
		
	}
}
    
}
