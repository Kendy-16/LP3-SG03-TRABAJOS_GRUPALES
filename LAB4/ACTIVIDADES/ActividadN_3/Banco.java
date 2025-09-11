import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, CuentaBancaria> cuentas = new HashMap<>();

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    public CuentaBancaria obtenerCuenta(String numero) throws CuentaNoEncontradaException {
        CuentaBancaria c = cuentas.get(numero);
        if (c == null) throw new CuentaNoEncontradaException("Cuenta " + numero + " no encontrada.");
        return c;
    }

    // Transferir: puede lanzar CuentaNoEncontradaException o SaldoInsuficienteException
    // (LimiteCreditoExcedidoException es una subclase de SaldoInsuficienteException).
    public void transferir(String numOrigen, String numDestino, double monto)
            throws CuentaNoEncontradaException, SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("El monto a transferir debe ser positivo.");

        CuentaBancaria origen = obtenerCuenta(numOrigen);
        CuentaBancaria destino = obtenerCuenta(numDestino);

        // Si origen.retirar lanza SaldoInsuficienteException (o su subclase LimiteCreditoExcedidoException),
        // la excepción se propagará hacia quien llamó a transferir.
        origen.retirar(monto);
        destino.depositar(monto);
    }

    public void listarCuentas() {
        System.out.println("\n---- Cuentas en el banco ----");
        for (CuentaBancaria c : cuentas.values()) System.out.println(c);
        System.out.println("----------------------------");
    }
}
