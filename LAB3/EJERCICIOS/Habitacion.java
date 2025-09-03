
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Habitacion {
    private int dia;
    private int mes;
    private int anio;
    private boolean disponible;
    private double precio;

    public Habitacion(int dia, int mes, int anio, boolean disponibilidad, double precio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.disponible = disponibilidad;
        this.precio = precio;
    }

    // Getters y setters
    protected double getPrecio() {
        return precio;
    }

    protected void setPrecio(double precio) {
        this.precio = precio;
    }

    protected boolean isDisponible() {
        return disponible;
    }

    protected void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    protected int getAnio() {
        return anio;
    }

    protected void setAnio(int anio) {
        this.anio = anio;
    }

    protected int getMes() {
        return mes;
    }

    protected void setMes(int mes) {
        this.mes = mes;
    }

    protected int getDia() {
        return dia;
    }

    protected void setDia(int dia) {
        this.dia = dia;
    }

    // Método para calcular días de hospedaje
    protected long diasHospedaje(int diaSalida, int mesSalida, int anioSalida) {
        LocalDate fechaEntrada = LocalDate.of(anio, mes, dia);
        LocalDate fechaSalida = LocalDate.of(anioSalida, mesSalida, diaSalida);
        return ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
    }
    
    //metodo calcular precio
    
    protected double calcularPrecio(int diaSalida, int mesSalida, int anioSalida) {
    	long dias = diasHospedaje(diaSalida, mesSalida, anioSalida);
    	return dias * precio;
    }
   
    protected void mostrarReserva(int diaSalida, int mesSalida, int anioSalida) {
        long dias = diasHospedaje(diaSalida, mesSalida, anioSalida);
        double costoTotal = dias * precio;

        System.out.println("Habitación reservada desde: " + dia + "/" + mes + "/" + anio);
        System.out.println("Hasta: " + diaSalida + "/" + mesSalida + "/" + anioSalida);
        System.out.println("Días de hospedaje: " + dias);
        System.out.println("Precio por día: $" + precio);
        System.out.println("Costo total: $" + costoTotal);
    }

}
