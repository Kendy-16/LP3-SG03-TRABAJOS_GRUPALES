public class Excepcion_de_vocal extends Exception{
    public Excepcion_de_vocal(char caracter) {
        super("Excepción de vocal: '" + caracter + "'");
    }
}
