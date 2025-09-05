
public class Suite extends Habitacion implements ServicioLimpieza, ServicioLavanderia, ServicioComida {
	private double precioPorPrivilegios;
	
	public Suite (int numero, String tipo, double precioPorDia, double precioPorPrivilegios) {
		super(numero, " Suite ", precioPorDia);
		this.setPrecioPorPrivilegios(precioPorPrivilegios);
		
	}
	
	@Override
	public double cacularPrecio(int dias) {
		return (getPrecioPorDia() + precioPorPrivilegios) * dias;
	}

	@Override
	public boolean tieneServiciosEsenciales() {
		return true;
	}

	@Override
	public void solicitarLimpieza() {
		System.out.println("Limpieza de Suite solicitada");
	}
	
	@Override
	public void limpiezaCompletada() {
		System.out.println("Limpieza de Suite completada");
	}

	@Override
	public void solicitarLavanderia() {
		System.out.println("Servicio de lavanderia de Suite solicitada");
	}
	
	@Override
	public double calcularCostoLavanderia(double kiloRopa) {
		return 30.0 * kiloRopa;
	}

	@Override
	public void soliciatComida() {
		System.out.println("Servicio de comida de Suite solicitada");
	}
	
	@Override
	public void entregaComida() {
		System.out.println("Entrega de comida a Suite");
	}
	
	@Override
	public double obtenerPrecioComida(int cantidadPlatos) {
		return 25.0 * cantidadPlatos;
	}
	
	//Getters y Setters

	public double getPrecioPorPrivilegios() {
		return precioPorPrivilegios;
	}

	public void setPrecioPorPrivilegios(double precioPorPrivilegios) {
		this.precioPorPrivilegios = precioPorPrivilegios;
	}

}
