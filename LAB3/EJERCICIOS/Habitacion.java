

public abstract class Habitacion {
	
    private int numero;
    private String tipo;
    private double precioPorDia;


    public Habitacion(int numero, String tipo, double precioPorDia) {
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setPrecioPorDia(precioPorDia);
    }
    
    public abstract double calcularPrecio(int dias);
    public abstract boolean tieneServiciosEsenciales(); 


    @Override
    public String toString() {
        return "Habitación N° " + getNumero() + 
        		"| Tipo de habitacion: " + getTipo() +
        		" | Precio: $" + getPrecioPorDia();
    }
    
    //Setters y Getters

	protected double getPrecioPorDia() {
		return precioPorDia;
	}

	protected void setPrecioPorDia(double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}


	protected String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

	protected int getNumero() {
		return numero;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}

}

