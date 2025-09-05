public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // depositar: valida monto positivo
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
    }

    // retirar: valida monto positivo y lanza SaldoInsuficienteException si no alcanza
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo disponible: " + saldo);
        }
        saldo -= monto;
    }

    // cerrarCuenta: sólo si saldo es cero, si no, lanza SaldoNoCeroException
    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0.0) {
            throw new SaldoNoCeroException("No se puede cerrar la cuenta. Saldo debe ser 0. Saldo actual: " + saldo);
        }
        // si llega aquí, la cuenta puede cerrarse (el Banco se encargará de removerla)
    }

    @Override
    public String toString() {
        return "Cuenta[" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + "]";
    }
}
