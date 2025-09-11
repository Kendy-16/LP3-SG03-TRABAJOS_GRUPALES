import java.util.Scanner;

class LeerEntrada {
    private char caracter;
    
    public char getChar() {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un carácter: ");
        String entrada = scanner.nextLine();
        
        if (entrada.length() > 0) {
            caracter = entrada.charAt(0);
        } else {
            caracter = ' '; 
        }
        
        return caracter;
        
    }
    
    public char getCaracterAlmacenado() {
        return caracter;
    }


}
