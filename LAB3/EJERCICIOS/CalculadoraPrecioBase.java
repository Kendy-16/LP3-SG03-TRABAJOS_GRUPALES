import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadoraPrecioBase implements CalculadoraPrecio {
    @Override
    public double calcularPrecio(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return habitacion.getPrecioPorDia() * dias;
    }
}
