public class PromocionClienteFrecuente implements Promocion {
    private double descuentoFijo;

    public PromocionClienteFrecuente(int minimoReservas, double descuentoFijo) {
        this.descuentoFijo = descuentoFijo;
    }

    @Override
    public double aplicarDescuento(double precioOriginal) {
        return Math.max(0, precioOriginal - descuentoFijo);
    }

    @Override
    public String getDescripcion() {
        return "Promoción Cliente Frecuente - $" + descuentoFijo + " de descuento";
    }

    @Override
    public boolean esAplicable(Reserva reserva) {
        return true;
    }
}
