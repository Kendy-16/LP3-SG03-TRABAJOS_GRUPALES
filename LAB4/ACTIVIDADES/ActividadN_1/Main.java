public class Main{
    
    public static void main(String[] args) {
        // Intento de cuenta con saldo negativo (IllegalArgumentException)
        try {
            CuentaBancaria cErr = new CuentaBancaria("0001", "UsuarioError", -100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Creación fallida (esperado): " + e.getMessage());
        }

        // Crear cuentas válidas
        CuentaBancaria cuentaA = new CuentaBancaria("1001", "Kendy", 500.0);
        CuentaBancaria cuentaB = new CuentaBancaria("1002", "Ale", 200.0);

        System.out.println("\nCuentas iniciales:");
        System.out.println(cuentaA);
        System.out.println(cuentaB);

        // Intento de depositar monto negativo (IllegalArgumentException)
        try {
            cuentaA.depositar(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("\nDepósito inválido (esperado): " + e.getMessage());
        }

        // Depositar correctamente
        cuentaA.depositar(150);
        System.out.println("\nDespués de depositar 150 a Kendy: " + cuentaA.getSaldo());

        // Intento de retirar mas que el saldo (SaldoInsuficienteException)
        try {
            cuentaB.retirar(500); // Max 200
        } catch (SaldoInsuficienteException e) {
            System.out.println("\nRetiro fallido (esperado): " + e.getMessage());
        }

        // Intento de retirar monto negativo (IllegalArgumentException)
        try {
            cuentaB.retirar(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("\nRetiro inválido (esperado): " + e.getMessage());
        }

        // Retiro válido
        cuentaB.retirar(50);
        System.out.println("\nDespués de retirar 50 de Ale: " + cuentaB.getSaldo());

        System.out.println("\nEstado final de cuentas:");
        System.out.println(cuentaA);
        System.out.println(cuentaB);
    }
}
