import java.time.LocalDateTime;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion
{
    
	@Override
    public boolean puedeCancelar(Reserva reserva) {
        return LocalDateTime.now().isBefore(reserva.getFechaCheckIn().minusHours(24));
    }
    
    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0.0; // Sin penalización
    }
}
