import java.time.LocalDate;
import java.time.Month;

public class PromocionTemporadaAlta implements Promocion {
    private double descuentoPorcentaje;

    public PromocionTemporadaAlta(double descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    @Override
    public double aplicarDescuento(double precioOriginal) {
        return precioOriginal * (1 - descuentoPorcentaje / 100);
    }

    @Override
    public String getDescripcion() {
        return "Promoción Temporada Alta - " + descuentoPorcentaje + "% de descuento";
    }

    @Override
    public boolean esAplicable(Reserva reserva) {
        LocalDate fechaEntrada = reserva.getFechaEntrada();
        // Temporada alta: enero, febrero, agosto y diciembre
        return fechaEntrada.getMonth() == Month.JANUARY||
               fechaEntrada.getMonth() == Month.FEBRUARY ||
               fechaEntrada.getMonth() == Month.AUGUST ||
               fechaEntrada.getMonth() == Month.DECEMBER;
    }
}
