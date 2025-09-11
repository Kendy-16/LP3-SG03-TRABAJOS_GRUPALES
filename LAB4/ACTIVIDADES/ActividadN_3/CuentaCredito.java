public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito; // >= 0

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        if (limiteCredito < 0) throw new IllegalArgumentException("El límite de crédito no puede ser negativo.");
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() { return limiteCredito; }

    // Sobrescribir retirar: permite que saldo final llegue hasta -limiteCredito.
    // Si el monto hace que se supere ese límite, lanza LimiteCreditoExcedidoException.
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("El monto a retirar debe ser positivo.");

        double disponibleConCredito = this.saldo + this.limiteCredito;
        if (monto > disponibleConCredito) {
            // lanza la excepción específica; es una subclase de SaldoInsuficienteException
            throw new LimiteCreditoExcedidoException(
                "Límite de crédito excedido. Disponible con crédito: " + disponibleConCredito
            );
        }

        this.saldo -= monto; // (puede dejar saldo negativo hasta -limiteCredito)
    }

    @Override
    public String toString() {
        return "CuentaCredito[" + getNumeroCuenta() + ", titular=" + getTitular() +
               ", saldo=" + saldo + ", limiteCredito=" + limiteCredito + "]";
    }
}
