public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        System.out.println("== Lista inicial ==");
        gestor.mostrar();

        System.out.println("\n== Agregando personajes ==");
        gestor.agregar(new Personaje("Konnor", 120, 25, 15, 3));
        gestor.agregar(new Personaje("Retep", 100, 30, 5, 4));
        gestor.agregar(new Personaje("Paithen", 90, 30, 10, 2));
        gestor.agregar(new Personaje("Lydiac", 110, 28, 20, 4));

        System.out.println("\n== Lista después de agregar ==");
        gestor.mostrar();

        System.out.println("\n== Modificando a Konnor ==");
        gestor.modificar("Konnor", 100, 40, 20, 8);

        System.out.println("\n== Lista después de modificar ==");
        gestor.mostrar();

        System.out.println("\n== Borrando a Paithen ==");
        gestor.borrar("Paithen");

        System.out.println("\n== Lista final ==");
        gestor.mostrar();
    }
}
