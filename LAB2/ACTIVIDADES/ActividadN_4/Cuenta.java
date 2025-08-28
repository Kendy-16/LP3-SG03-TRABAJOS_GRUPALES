public class Cuenta {
    private int numero;
    private double saldo;

    // Constructor con número y saldo inicial
    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    // Constructor solo con número (saldo = 0 por defecto)
    public Cuenta(int numero) {
        this(numero, 0.0);
    }

    // Métodos
    public int getNumCuenta() {
        return numero;
    }

    public void setNumCuenta(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta [numero=" + numero + ", saldo=" + saldo + "]";
    }
}
