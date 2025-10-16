import java.util.*;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        System.out.println("== Lista inicial ==");
        gestor.mostrar();

        System.out.println("\n== Agregando personajes ==");
        gestor.agregar(new Personaje("Konnor", 9, 25, 15, 3));
        gestor.agregar(new Personaje("Retep", 101, 30, 5, 4));
        gestor.agregar(new Personaje("Paithen", 39, 30, 10, 2));
        gestor.agregar(new Personaje("Lydiac", 19, 28, 20, 4));
        gestor.agregar(new Personaje("Carlos", 1, 38, 50, 6));
        gestor.agregar(new Personaje("Flor", 2, 40, 10, 3));

        System.out.println("\n== Lista después de agregar ==");
        gestor.mostrar();

        System.out.println("\n== Modificando a Konnor ==");
        gestor.modificar("Konnor", 39, 40, 20, 8);

        System.out.println("\n== Lista después de modificar ==");
        gestor.mostrar();

        System.out.println("\n== Borrando a Paithen ==");
        gestor.borrar("Paithen");

        System.out.println("\n== Lista final ==");
        gestor.mostrar();

        System.out.println("\n== Lista Ordenada por Vida (Menor a Mayor) ==");
        gestor.mostrarVida();

        System.out.println("\n== Mostrar estadisticas de atributos de Personajes ==");
        gestor.mostrarEstadisticas();        
    }
}
