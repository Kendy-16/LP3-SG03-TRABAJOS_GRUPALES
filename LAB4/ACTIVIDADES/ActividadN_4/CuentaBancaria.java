import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;
    private final List<String> transacciones = new ArrayList<>();

    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial no puede ser negativo.");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        // registro inicial
        registrarTransaccion("CREACION", saldoInicial);
    }
    
    //Constructor para cuentas vacías
    public CuentaBancaria(String numeroCuenta, String titular) {
    this.numeroCuenta = numeroCuenta;
    this.titular = titular;
    this.saldo = 0.0;
    // no registrar "CREACION"
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    // devuelve una copia inmutable del historial (seguridad básica)
    public List<String> getTransacciones() {
        return Collections.unmodifiableList(transacciones);
    }

    protected void registrarTransaccion(String tipo, double monto) {
        String time = LocalDateTime.now().format(F);
        String linea = tipo + " -- " + time + " -- " + monto + " -- " + saldo;
        transacciones.add(linea);
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        saldo += monto;
        registrarTransaccion("DEPOSITO", monto);
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente. Saldo actual: " + saldo);
        saldo -= monto;
        registrarTransaccion("RETIRO  ", monto);
    }

    @Override
    public String toString() {
        return "Cuenta[" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + "]";
    }
}
