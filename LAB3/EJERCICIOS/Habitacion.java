import java.util.ArrayList;
import java.util.List;

public class Habitacion {
	
    private int numero;
    private double precioPorDia;
    private List<Reserva> reservas;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(int numero, double precioPorDia) {
        this.numero = numero;
        this.precioPorDia = precioPorDia;
        this.reservas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

	public GestorDisponibilidadHabitacion getGestorDisponibilidad() {
		return gestorDisponibilidad;
	}

	public void setGestorDisponibilidad(GestorDisponibilidadHabitacion gestorDisponibilidad) {
		this.gestorDisponibilidad = gestorDisponibilidad;
	}

    @Override
    public String toString() {
        return "Habitación N° " + numero + " | Precio: $" + precioPorDia;
    }

}

