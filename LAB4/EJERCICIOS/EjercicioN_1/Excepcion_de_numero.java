public class Excepcion_de_numero extends Exception{
    public Excepcion_de_numero(char caracter) {
        super("Excepción de número: '" + caracter + "'");
    }
}
