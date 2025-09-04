
public class PoliticaCancelacionEstricta implements PoliticaCancelacion{
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return false; // No permite cancelaciones
    }
    
    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return reserva.calcularCosto(); // 100% de penalización
    }
}
