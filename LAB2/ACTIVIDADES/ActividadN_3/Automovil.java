package L2;
import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;
public class Automovil {
	//Atributos
	private String placa;
	private int numPuertas;
	private String marca;
	private String modelo;
	private Motor motor;
    private List<Motor> motores = new ArrayList<>();

	
	
	//Constructor
	
    public Automovil ( String placa, int numPuertas, String marca, String modelo, Motor motorElegido) {

        this.setPlaca(placa);
        this.setNumPuertas(numPuertas);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.motor = motorElegido;
        this.motores = new ArrayList<>();
    }

    	
	//Getts y Setts
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	//Metodos
	public String toString() {
        return "Modelo: " + modelo +
               " | Marca: " + marca +
               " | Placa: " + placa +
               "\n" + motor.toString();

	}
	
    public void agregarMotor(Motor motor) {
        motores.add(motor);
    }
	
	public Motor testAgregacion() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nMotores existentes: ");
		
		int i = 0;
		
		for(Motor m: motores) {
			System.out.println("Motor N° " + i + ": " + m.toString());
			++i;

		}
        System.out.print("Ingrese el número del motor que desea seleccionar: ");
        int respuesta = entrada.nextInt();

	   if (respuesta < 0 || respuesta >= motores.size()) {
            System.out.println("Selección inválida.");
            return null;
        }
    
        Motor motorSeleccionado = motores.get(respuesta);
        return motorSeleccionado;
	}
}//Fin de clase Automovil
