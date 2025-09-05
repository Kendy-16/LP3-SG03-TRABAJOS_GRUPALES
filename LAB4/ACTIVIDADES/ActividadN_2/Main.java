public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Crear y agregar cuentas
        CuentaBancaria c1 = new CuentaBancaria("A001", "Kendy", 500.0);
        CuentaBancaria c2 = new CuentaBancaria("B002", "Ale", 200.0);
        CuentaBancaria c3 = new CuentaBancaria("C003", "Kirby", 0.0);

        banco.agregarCuenta(c1);
        banco.agregarCuenta(c2);
        banco.agregarCuenta(c3);

        banco.listarCuentas();

        // Transferencia válida
        try {
            System.out.println("\n-- Transferencia válida: Kendy -> Ale (100)");
            banco.transferir("A001", "B002", 100.0);
            System.out.println("Transferencia correcta.");
        } catch (Exception e) {
            System.out.println("Error en transferencia válida (no esperado): " + e.getMessage());
        }
        banco.listarCuentas();

        // Transferencia a cuenta inexistente (CuentaNoEncontradaException)
        try {
            System.out.println("\n-- Transferencia a cuenta inexistente: Kendy -> Z999 (50)");
            banco.transferir("A001", "Z999", 50.0);
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Transferencia fallida (esperado): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error: " + e.getMessage());
        }

        // Transferencia con saldo insuficiente (SaldoInsuficienteException)
        try {
            System.out.println("\n-- Transferencia con saldo insuficiente: Ale -> Kendy (1000)");
            banco.transferir("B002", "A001", 1000.0); // No tiene tanto en la cuenta
        } catch (SaldoInsuficienteException e) {
            System.out.println("Transferencia fallida (esperado): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error: " + e.getMessage());
        }
        banco.listarCuentas();

        // Intentar cerrar cuenta con saldo (SaldoNoCeroException)
        try {
            System.out.println("\n-- Cerrar cuenta con saldo: Kendy");
            banco.cerrarCuenta("A001");
        } catch (SaldoNoCeroException e) {
            System.out.println("Cierre fallido (esperado): " + e.getMessage());
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Cuenta no encontrada: " + e.getMessage());
        }

        // Cerrar cuenta sin saldo
        try {
            System.out.println("\n-- Cerrar cuenta sin saldo: Kirby (C003)");
            banco.cerrarCuenta("C003");
            System.out.println("Cuenta C003 cerrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cerrar cuenta C003 (no esperado): " + e.getMessage());
        }

        banco.listarCuentas();

        // Intentar cerrar cuenta ya eliminada (CuentaNoEncontradaException)
        try {
            System.out.println("\n-- Intentar cerrar cuenta eliminada C003 otra vez");
            banco.cerrarCuenta("C003");
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Cierre fallido (esperado): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error: " + e.getMessage());
        }
    }
}
