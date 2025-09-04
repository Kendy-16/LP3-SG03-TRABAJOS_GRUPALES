import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidadHabitacion {
	private Habitacion habitacion;
	private List<Reserva> reservas;
    private boolean disponible;

	
	public GestorDisponibilidadHabitacion(Habitacion habitacion,  List<Reserva> reservas) {
		this.setHabitacion(habitacion);
		this.setReservas(reservas);
        this.disponible = true; 

	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
	
    public boolean verificarDisponibilidad() {
        LocalDate hoy = LocalDate.now();
        return estaDisponible(hoy, hoy);
    }
	
    public boolean estaDisponible(LocalDate entrada, LocalDate salida) {
        for (Reserva r : getReservas()) {
            if (!(salida.isBefore(r.getFechaEntrada()) || entrada.isAfter(r.getFechaSalida()))) {
                return false;
            }
        }
        return true;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        this.disponible = false;
    }

    @Override
    public String toString() {
    	return "Disponibilidad" + disponible;
    }
    
}
