import java.util.List;
import java.util.Scanner;

public class EmpleadoVista {
    private Scanner scanner;

    public EmpleadoView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE EMPLEADOS ===");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar un empleado por su número");
        System.out.println("4. Eliminar un empleado por su número");
        System.out.println("5. Salir del programa");
        System.out.println("=========================================");
    }

    public void mostrarEmpleados(List<Empleado> empleados) {
        System.out.println("\n=== LISTA DE EMPLEADOS ===");
        System.out.println("Total de empleados: " + empleados.size());
        System.out.println("---------------------------------------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
        System.out.println("---------------------------------------------");
    }

    public void mostrarEmpleado(Empleado empleado) {
        System.out.println("\n=== EMPLEADO ENCONTRADO ===");
        System.out.println(empleado);
        System.out.println("----------------------------");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String error) {
        System.out.println("✗ Error: " + error);
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número entero válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
