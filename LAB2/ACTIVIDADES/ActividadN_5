import java.util.ArrayList;
import java.util.Scanner;

//####Banco.java######

public class Banco {

    // Clase base
    abstract static class Cuenta {
        protected int numeroCuenta;
        protected double saldo;

        public Cuenta(int numeroCuenta, double saldoInicial) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldoInicial;
        }

        public void depositar(double monto) {
            if (monto > 0) {
                saldo += monto;
            }
        }

        public void retirar(double monto) {
            if (monto > 0 && monto <= saldo) {
                saldo -= monto;
            } else {
                System.out.println("Fondos insuficientes o monto inválido.");
            }
        }

        public double getSaldo() {
            return saldo;
        }

        public int getNumeroCuenta() {
            return numeroCuenta;
        }

        public abstract void consultar();
    }

    // Subclase Cuenta de Ahorro
    static class CuentaAhorro extends Cuenta {
        private double tasaInteres;
        private double saldoMinimoMensual;

        public CuentaAhorro(int numeroCuenta, double saldoInicial, double tasaInteres) {
            super(numeroCuenta, saldoInicial);
            this.tasaInteres = tasaInteres;
            this.saldoMinimoMensual = saldoInicial;
        }

        @Override
        public void retirar(double monto) {
            if (monto > 0 && monto <= saldo) {
                super.retirar(monto);
                if (saldo < saldoMinimoMensual) {
                    saldoMinimoMensual = saldo;
                }
            } else {
                System.out.println("Retiro no válido.");
            }
        }

        @Override
        public void consultar() {
            double interes = saldoMinimoMensual * tasaInteres;
            depositar(interes);
            System.out.println("Intereses acumulados: " + interes + " en cuenta ahorro " + numeroCuenta);
            saldoMinimoMensual = saldo; // reinicia para el próximo mes
        }
    }

    // Subclase Cuenta Corriente
    static class CuentaCorriente extends Cuenta {
        private int contadorRetiros;
        private static final int RETIROS_GRATIS = 3;
        private static final double COSTO_RETIRO_EXTRA = 3.0;

        public CuentaCorriente(int numeroCuenta, double saldoInicial) {
            super(numeroCuenta, saldoInicial);
            this.contadorRetiros = 0;
        }

        @Override
        public void retirar(double monto) {
            if (monto > 0 && monto <= saldo) {
                super.retirar(monto);
                contadorRetiros++;
                if (contadorRetiros > RETIROS_GRATIS) {
                    super.retirar(COSTO_RETIRO_EXTRA);
                    System.out.println("Se aplicó un cargo de S/.3.0 por retiro extra.");
                }
            } else {
                System.out.println("Retiro no válido.");
            }
        }

        @Override
        public void consultar() {
            contadorRetiros = 0; // reinicia el contador
            System.out.println("Consultada cuenta corriente " + numeroCuenta + ". Contador de retiros reiniciado.");
        }
    }


    // Método principal con menú
    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        // Crear 5 cuentas de ahorro y 5 corrientes
        for (int i = 1; i <= 5; i++) {
            cuentas.add(new CuentaAhorro(1000 + i, 1000.0, 0.02)); // 2% mensual
            cuentas.add(new CuentaCorriente(2000 + i, 1500.0));
        }

        Scanner sc = new Scanner(System.in);
        char opcion;

        do {
            System.out.println("\n===== MENU BANCO =====");
            System.out.println("D) Depositar");
            System.out.println("R) Retirar");
            System.out.println("C) Consultar");
            System.out.println("S) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.next().toUpperCase().charAt(0);

            if (opcion == 'D' || opcion == 'R') {
                System.out.print("Ingrese número de cuenta: ");
                int numero = sc.nextInt();
                System.out.print("Ingrese monto: ");
                double monto = sc.nextDouble();

                boolean encontrada = false;
                for (Cuenta c : cuentas) {
                    if (c.getNumeroCuenta() == numero) {
                        encontrada = true;
                        if (opcion == 'D') {
                            c.depositar(monto);
                            System.out.println("Depósito exitoso. Saldo actual: " + c.getSaldo());
                        } else {
                            c.retirar(monto);
                            System.out.println("Retiro realizado. Saldo actual: " + c.getSaldo());
                        }
                    }
                }
                if (!encontrada) {
                    System.out.println("Cuenta no encontrada.");
                }
            } else if (opcion == 'C') {
                System.out.println("\n=== Consulta de todas las cuentas ===");
                for (Cuenta c : cuentas) {
                    c.consultar();
                    System.out.println("Cuenta " + c.getNumeroCuenta() +
                            " - Saldo: " + c.getSaldo());
                }
            }

        } while (opcion != 'S');

        System.out.println("Gracias por usar el sistema bancario.");
        sc.close();
    }
}
