
abstract public class  Habitacion {
	
	private int numHabitacion;
	private boolean ocupado;
	private double precioPorDia;
	
	Habitacion(int numHabitacion, boolean ocupado, double precioPorDia) {
		this.numHabitacion = numHabitacion;
		this.ocupado = false;
		this.precioPorDia = precioPorDia;
	}

	
	  public int getNumHabitacion() {
	       return numHabitacion;
	   }

	   public boolean isOcupado() {
	       return ocupado;
	   }
	   
	//Para sobreescribir
	protected abstract double getPrecioPorDia();


}
