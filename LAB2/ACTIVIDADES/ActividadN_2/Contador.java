public class Contador {
    private int valor;
    static int acumulador = 0;

    public static int acumulador{
        return acumulador;
    }
    
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
        return this.valor;
    }

    // Getter de acumulador
    public static int getAcumulador() {
        return this.acumulador;
    }
}
