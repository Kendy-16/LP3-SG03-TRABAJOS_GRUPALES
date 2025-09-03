import java.util.ArrayList;
import java.util.List;

public class Habitacion {
	
    private int numero;
    private boolean disponible;
    private double precioPorDia;
    private List<Reserva> reservas;

    public Habitacion(int numero, double precioPorDia) {
        this.numero = numero;
        this.precioPorDia = precioPorDia;
        this.disponible = true; 
        this.reservas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        this.disponible = false;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Habitación N° " + numero + " | Precio: $" + precioPorDia +
               " | Estado: " + (disponible ? "Disponible" : "Ocupada");
    }
}
