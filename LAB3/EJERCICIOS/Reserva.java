import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
	
    private Habitacion habitacion;
    private Huesped huesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva(Habitacion habitacion, Huesped huesped, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;

        habitacion.setDisponible(false);
    }

    public long getDiasHospedaje() {
        return ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
    }

    public double calcularCosto() {
        return getDiasHospedaje() * habitacion.getPrecioPorDia();
    }

    @Override
    public String toString() {
        return "Reserva de " + huesped +
               " | Habitación: " + habitacion.getNumero() +
               " | Desde: " + fechaEntrada +
               " | Hasta: " + fechaSalida +
               " | Días: " + getDiasHospedaje() +
               " | Costo total: $" + calcularCosto();
    }
}
