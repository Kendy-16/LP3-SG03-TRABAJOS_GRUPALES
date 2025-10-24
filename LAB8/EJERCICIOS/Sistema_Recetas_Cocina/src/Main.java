import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecetaDAO dao = new RecetaDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE RECETAS ===");
            System.out.println("1. Insertar receta");
            System.out.println("2. Mostrar recetas");
            System.out.println("3. Actualizar receta");
            System.out.println("4. Eliminar receta");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingredientes: ");
                    String ingredientes = sc.nextLine();
                    System.out.print("Preparación: ");
                    String preparacion = sc.nextLine();
                    dao.insertar(new Receta(nombre, ingredientes, preparacion));
                    break;

                case 2:
                    List<Receta> lista = dao.listar();
                    for (Receta r : lista)
                        System.out.println(r);
                    break;

                case 3:
                    System.out.print("ID de la receta a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Nuevos ingredientes: ");
                    ingredientes = sc.nextLine();
                    System.out.print("Nueva preparación: ");
                    preparacion = sc.nextLine();
                    dao.actualizar(new Receta(idAct, nombre, ingredientes, preparacion));
                    break;

                case 4:
                    System.out.print("ID de la receta a eliminar: ");
                    int idDel = sc.nextInt();
                    dao.eliminar(idDel);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        DatabaseConnection.close();
    }
}
