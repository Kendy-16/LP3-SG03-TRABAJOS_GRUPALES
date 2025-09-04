import java.time.LocalDateTime;


public class PoliticaCancelacionModerada implements PoliticaCancelacion{
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return LocalDateTime.now().isBefore(reserva.getFechaCheckIn().minusHours(72));
    }
    
    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return reserva.calcularCosto() * 0.5; // 50% de penalización
    }
}
