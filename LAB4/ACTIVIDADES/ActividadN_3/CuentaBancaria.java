public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo; 

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        saldo += monto;
    }

    // Retirar en cuenta normal: solo si hay saldo suficiente.
    // Lanza SaldoInsuficienteException si no hay saldo suficiente.
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo disponible: " + saldo);
        }
        saldo -= monto;
    }
    
    @Override
    public String toString() {
        return "Cuenta[" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + "]";
    }
}
