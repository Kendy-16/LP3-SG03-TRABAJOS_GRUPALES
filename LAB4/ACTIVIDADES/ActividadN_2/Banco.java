import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, CuentaBancaria> cuentas = new HashMap<>();

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    // Obtener cuenta o lanzar excepción si no existe
    public CuentaBancaria obtenerCuenta(String numero) throws CuentaNoEncontradaException {
        CuentaBancaria c = cuentas.get(numero);
        if (c == null) {
            throw new CuentaNoEncontradaException("Cuenta " + numero + " no encontrada.");
        }
        return c;
    }

    // Transferir entre cuentas por número (verifica existencia y saldo)
    public void transferir(String numOrigen, String numDestino, double monto)
            throws CuentaNoEncontradaException, SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a transferir debe ser positivo.");
        }

        CuentaBancaria origen = obtenerCuenta(numOrigen); // puede lanzar CuentaNoEncontradaException
        CuentaBancaria destino = obtenerCuenta(numDestino); // puede lanzar CuentaNoEncontradaException

        // Intentar retirar primero (si falla, no depositamos)
        origen.retirar(monto); // puede lanzar SaldoInsuficienteException
        destino.depositar(monto);
    }

    // Cerrar cuenta por número: lanza CuentaNoEncontradaException o SaldoNoCeroException
    public void cerrarCuenta(String numero) throws CuentaNoEncontradaException, SaldoNoCeroException {
        CuentaBancaria cuenta = obtenerCuenta(numero);
        cuenta.cerrarCuenta(); // lanza SaldoNoCeroException si saldo != 0
        // si no lanzó excepción, la removemos del sistema
        cuentas.remove(numero);
    }

    // Método utilitario para mostrar todas las cuentas 
    public void listarCuentas() {
        System.out.println("---- Cuentas en el banco ----");
        for (CuentaBancaria c : cuentas.values()) {
            System.out.println(c);
        }
        System.out.println("----------------------------");
    }
}
