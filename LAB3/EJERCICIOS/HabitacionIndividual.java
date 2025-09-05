
public class HabitacionIndividual extends Habitacion implements ServicioLimpieza {

	
	public HabitacionIndividual (int numero, String tipo, double precioPorDia) {
		super(numero, " Habitación Individual ", precioPorDia);
	}
	
	@Override
	public double cacularPrecio(int dias) {
		return (getPrecioPorDia() * dias);
	}

	@Override
	public boolean tieneServiciosEsenciales() {
		return true;
	}
	
	@Override
	public void solicitarLimpieza() {
		System.out.println("Limpieza de habitacion individual solicitada");
	}
	
	@Override
	public void limpiezaCompletada() {
		System.out.println("Limpieza de habitacion individual completada");
	}
	
}
