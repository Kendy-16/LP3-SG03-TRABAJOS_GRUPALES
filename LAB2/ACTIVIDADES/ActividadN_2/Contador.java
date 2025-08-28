public class Contador {
    private int valor;
    static int acumulador = 0;

    // Constructor
    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
    }

    // Método incrementar
    public void inc() {
        valor++;
        acumulador++;
    }

    // Getter de valor
    public int getValor() {
        return valor;
    }

    // Getter de acumulador
    public static int getAcumulador() {
        return acumulador;
    }
}
