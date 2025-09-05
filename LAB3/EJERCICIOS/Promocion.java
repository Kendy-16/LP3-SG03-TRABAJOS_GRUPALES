public interface Promocion {
	
    double aplicarDescuento(double precioOriginal);
    String getDescripcion();
    boolean esAplicable(Reserva reserva);
    
}
