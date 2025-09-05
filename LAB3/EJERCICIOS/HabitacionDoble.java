
public class HabitacionDoble extends Habitacion implements ServicioLimpieza, ServicioLavanderia {

	private double precioExtra;

	
	public HabitacionDoble (int numero, String tipo, double precioPorDia, double precioExtra) {
		super(numero, " Habitación Doble ", precioPorDia);
		this.setPrecioExtra(precioExtra);
	}

	@Override
	public double cacularPrecio(int dias) {
		return (getPrecioPorDia() + getPrecioExtra())*dias;
	}

	@Override
	public boolean tieneServiciosEsenciales() {
		return true;
	}

	@Override
	public void solicitarLimpieza() {
		System.out.println("Limpieza de habitacion doble solicitada");
	}
	
	@Override
	public void limpiezaCompletada() {
		System.out.println("Limpieza de habitacion doble completada");
	}
	
	@Override
	public void solicitarLavanderia() {
		System.out.println("Servicio de lavanderia de habitacion doble solicitada");
	}
	
	@Override
	public double calcularCostoLavanderia(double kiloRopa) {
		return 12 * kiloRopa ;
	}
	
	//Getters y Setters

	public double getPrecioExtra() {
		return precioExtra;
	}

	public void setPrecioExtra(double precioExtra) {
		this.precioExtra = precioExtra;
	}
	

}
