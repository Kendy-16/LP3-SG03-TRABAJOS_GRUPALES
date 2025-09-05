// Excepción personalizada

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException() {
        super();
    }
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
