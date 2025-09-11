import java.util.Scanner;
import java.util.InputMismatchException;

class DividirPorCero extends Exception {
    public DividirPorCero() {
        super("Excepcion: No se puede dividir por 0");
    }
}    
class Calculadora {

    public double sumar(double a, double b) {
        return a + b;
    }
    public double restar(double a, double b) {
        return a - b;
    }
    public double multiplicar(double a, double b) {
        return a * b;
    }
    public double dividir(double a, double b) throws DividirPorCero {
        if(b == 0) {
            throw new DividirPorCero();
        } else {
            return a / b;
        }    
    }
}

class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        double a = 0, b = 0;
        boolean valoresValidos = false;
        
        do {
            try {
                System.out.println("Ingrese el valor para a: ");
                a = scanner.nextDouble();
                
                System.out.println("Ingrese el valor para b: ");
                b = scanner.nextDouble();
                
                valoresValidos = true;
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next();
            }
            
        } while (!valoresValidos);
        
        try {
            System.out.println("\nResultados:");
            System.out.println("Suma: " + calc.sumar(a, b));
            System.out.println("Resta: " + calc.restar(a, b));
            System.out.println("Multiplicación: " + calc.multiplicar(a, b));
            System.out.println("División: " + calc.dividir(a, b));
            
        } catch (DividirPorCero e) {
            System.out.println("Suma: " + calc.sumar(a, b));
            System.out.println("Resta: " + calc.restar(a, b));
            System.out.println("Multiplicación: " + calc.multiplicar(a, b));
            System.out.println(e.getMessage()); 
        }

        scanner.close();
    }
}
