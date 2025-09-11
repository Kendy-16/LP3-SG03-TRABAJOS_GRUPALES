
public class ManejoExcepciones {
    private LeerEntrada lector;
    
    public ManejoExcepciones() {
        this.lector = new LeerEntrada();
        System.out.println("Constructor de la clase Manejo de Excepciones llamado");
    }
    
    public void procesar() throws Excepcion_de_blanco, Excepcion_de_numero, Excepcion_de_salida, Excepcion_de_vocal {
        char caracter = lector.getChar();
        
        if (caracter == 's' || caracter == 'S') {
            throw new Excepcion_de_salida();
        }
        
        if (Character.isWhitespace(caracter)) {
            throw new Excepcion_de_blanco();
        }
        
        if (esVocal(caracter)) {
            throw new Excepcion_de_vocal(caracter);
        }
        
        if (Character.isDigit(caracter)) {
            throw new Excepcion_de_numero(caracter);
        }
        
        System.out.println("Carácter válido: '" + caracter + "'");
    }
    
    private boolean esVocal(char c) {
        char caracter = Character.toLowerCase(c);
        return "aeiouáéíóú".indexOf(caracter) != -1;
    }
}
