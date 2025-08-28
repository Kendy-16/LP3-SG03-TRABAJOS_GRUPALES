public class Contador {
    private int valor;
    public static final int VALOR_INICIAL = 10;
    private static int acumulador = 0;

    // j.1 número de contadores creados
    private static int nContadores = 0;

    // j.2 valor inicial del último contador creado
    private static int ultimoContador = 0;

    // Constructor que recibe valor
    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
        // actualizar contadores de clase
        nContadores++;
        ultimoContador = valor;
    }

    // Constructor por defecto delega en el anterior
    public Contador() {
        this(VALOR_INICIAL);
    }

    public void inc() {
        valor++;
        acumulador++;
    }

    public int getValor() {
        return this.valor;
    }

    public static int getAcumulador() {
        return acumulador;
    }

    // getters para las nuevas variables de clase
    public static int getNContadores() {
        return nContadores;
    }

    public static int getUltimoContador() {
        return ultimoContador;
    }
}
