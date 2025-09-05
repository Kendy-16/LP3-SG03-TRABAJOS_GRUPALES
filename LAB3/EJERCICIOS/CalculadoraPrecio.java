import java.time.LocalDate;

 interface CalculadoraPrecio {
    double calcularPrecio(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin);
}
