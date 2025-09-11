import java.util.Scanner;
import java.util.InputMismatchException;

class Numero {
    private double valor;
    
    public Numero() {
        this.valor = 0.0;
    }
    
    public Numero(double valor) {
        setValor(valor); 
    }
    
    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Error: El valor no puede ser negativo. Valor ingresado: " + valor);
        }
        this.valor = valor;
    }
    
    public double getValor() {
        return this.valor;
    }
    
    public double calcularRaizCuadrada() {
        return Math.sqrt(this.valor);
    }
    
    public double calcularLogaritmo() {
        if (this.valor == 0) {
            throw new IllegalArgumentException("Error: No se puede calcular logaritmo de cero");
        }
        return Math.log(this.valor);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Numero numero = new Numero();
        boolean valorValido = false;
        
        System.out.println("=== GESTIÓN DE NÚMEROS NO NEGATIVOS ===");
        
        do {
            try {
                System.out.print("Ingrese un número no negativo: ");
                double valorIngresado = scanner.nextDouble();
                
                numero.setValor(valorIngresado);
                valorValido = true;
                
                System.out.println("\nValor establecido correctamente: " + numero.getValor());
                
                System.out.println("Raíz cuadrada: " + numero.calcularRaizCuadrada());
                
                try {
                    System.out.println("Logaritmo natural: " + numero.calcularLogaritmo());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                
            } catch (IllegalArgumentException e) {
                System.out.println("(!)" + e.getMessage());
                System.out.println("Por favor, ingrese un número válido.\n");
                
            } catch (InputMismatchException e) {
                System.out.println("(!)Error: Debe ingresar un número válido.");
                scanner.next();
                System.out.println("Por favor, ingrese un número válido.\n");
            }
            
        } while (!valorValido);
        
        scanner.close();
    }
}
