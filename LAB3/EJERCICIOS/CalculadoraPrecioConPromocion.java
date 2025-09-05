import java.time.LocalDate;

public class CalculadoraPrecioConPromocion implements CalculadoraPrecio {
    private CalculadoraPrecio calculadoraBase;
    private Promocion promocion;
    
    public CalculadoraPrecioConPromocion(CalculadoraPrecio base, Promocion promocion) {
        this.calculadoraBase = base;
        this.promocion = promocion;
    }
    
    @Override
    public double calcularPrecio(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        double precioBase = calculadoraBase.calcularPrecio(habitacion, fechaInicio, fechaFin);
        return promocion.aplicarDescuento(precioBase);
    }
}
