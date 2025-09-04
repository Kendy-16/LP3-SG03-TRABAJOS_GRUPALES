import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidadHabitacion {
	private Habitacion habitacion;
	private List<Reserva> reservas;
	
	public GestorDisponibilidadHabitacion(Habitacion habitacion,  List<Reserva> reservas) {
		this.habitacion = habitacion;
		this.reservas = reservas;
	}
	
	public boolean verificarDisponiblidad() {
		return habitacion.isDisponible();
	}
	
    public boolean estaDisponible(LocalDate entrada, LocalDate salida) {
        for (Reserva r : reservas) {
            if (!(salida.isBefore(r.getFechaEntrada()) || entrada.isAfter(r.getFechaSalida()))) {
                return false;
            }
        }
        return true;
    }
}
