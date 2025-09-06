import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;

public class Reserva {
	
	private final int id;
	private String nombre;
    private Habitacion habitacion;
    private Huesped huesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private LocalDateTime fechaCheckIn;
    private LocalDateTime fechaCheckOut;
    private PoliticaCancelacion cancelacion;

    public Reserva(int id, String nombre, Habitacion habitacion, Huesped huesped, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.id = id;
        this.nombre = nombre;
    	this.setHabitacion(habitacion);
        this.setHuesped(huesped);
        this.setFechaEntrada(fechaEntrada);
        this.setFechaSalida(fechaSalida);
        this.setFechaCheckIn(fechaCheckIn);
        this.setFechaCheckOut(fechaCheckOut);
        this.setCancelacion(cancelacion);

        //habitacion.setDisponible(false);
    }

    public long getDiasHospedaje() {
        return ChronoUnit.DAYS.between(getFechaEntrada(), getFechaSalida());
    }

    public double calcularCosto() {
        return getDiasHospedaje() * getHabitacion().getPrecioPorDia();
    }
    
    public boolean cancelarReserva(PoliticaCancelacion cancelar) {
    	if(cancelar.puedeCancelar(this)) {
    		double penalizacion = cancelar.calcularPenalizacion(this);
    		return true;
    	}
    	return false;
    	
    }

    @Override
    public String toString() {
        return "Reserva de " + getHuesped() +
               " | Habitación: " + getHabitacion().getNumero() +
               " | Desde: " + getFechaEntrada() +
               " | Hasta: " + getFechaSalida() +
               " | Días: " + getDiasHospedaje() +
               " | Check-In: " + getFechaCheckIn()+
               " | Check-Out: " + getFechaCheckOut()+
               " | Costo total: $" + calcularCosto();
    }
   

    //Getter y Setters
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	

	public LocalDateTime getFechaCheckOut() {
		return fechaCheckOut;
	}

	public void setFechaCheckOut(LocalDateTime fechaCheckOut) {
		this.fechaCheckOut = fechaCheckOut;
	}

	public LocalDateTime getFechaCheckIn() {
		return fechaCheckIn;
	}

	public void setFechaCheckIn(LocalDateTime fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}

	public PoliticaCancelacion getCancelacion() {
		return cancelacion;
	}

	public void setCancelacion(PoliticaCancelacion cancelacion) {
		this.cancelacion = cancelacion;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
