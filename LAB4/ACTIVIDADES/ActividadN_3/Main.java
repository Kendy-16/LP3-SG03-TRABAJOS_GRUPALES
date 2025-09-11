public class Main {
  
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Cuentas:
        // Cuenta normal sin crédito
        CuentaBancaria cNormal = new CuentaBancaria("N1", "Cuenta Normal", 300.0);
        // Cuenta de crédito con límite 200 (puede quedar hasta -200)
        CuentaCredito cCredito = new CuentaCredito("C2", "Cuenta Crédito", 100.0, 200.0);

        banco.agregarCuenta(cNormal);
        banco.agregarCuenta(cCredito);

        banco.listarCuentas();

        System.out.println("\n-- Prueba 1: Retiro en cuenta normal con saldo suficiente (200)");
        try {
            cNormal.retirar(200.0); // OK
            System.out.println("Retiro OK. Saldo N1: " + cNormal.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n-- Prueba 2: Retiro en cuenta normal con saldo insuficiente (200)");
        try {
            cNormal.retirar(200.0); // Saldo actual 100 -> faltará => SaldoInsuficienteException
        } catch (SaldoInsuficienteException e) {
            System.out.println("Retiro fallido: " + e.getMessage());
        }

        System.out.println("\n-- Prueba 3: Retiro en cuenta crédito dentro del límite (250)");
        try {
            cCredito.retirar(250.0); // saldo 100 -> deja saldo -150, dentro de -200 => OK
            System.out.println("Retiro OK. Saldo C2: " + cCredito.getSaldo());
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Límite crédito excedido: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente: " + e.getMessage());
        }

        System.out.println("\n-- Prueba 4: Retiro en cuenta crédito excediendo el límite (300)");
        try {
            cCredito.retirar(300.0); // disponible con crédito = -150 + 200 = 50 -> 300 > 50 -> excede
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Retiro fallido: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo insuficiente: " + e.getMessage());
        }

        banco.listarCuentas();

        System.out.println("\n-- Prueba 5: Transferencia desde cuenta crédito dentro del límite (C200 -> N100, 50)");
        try {
            banco.transferir("C2", "N1", 50.0);
            System.out.println("Transferencia OK.");
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Transferencia fallida: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Transferencia fallida: " + e.getMessage());
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Cuenta no encontrada: " + e.getMessage());
        }

        System.out.println("\n-- Prueba 6: Transferencia desde cuenta crédito excediendo el límite (C200 -> N100, 1000)");
        try {
            banco.transferir("C2", "N1", 1000.0);
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("Transferencia fallida: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Transferencia fallida: " + e.getMessage());
        } catch (CuentaNoEncontradaException e) {
            System.out.println("Cuenta no encontrada: " + e.getMessage());
        }

        banco.listarCuentas();
    }
}
