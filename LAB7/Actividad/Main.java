public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        System.out.println("== Lista inicial ==");
        gestor.mostrar();

        System.out.println("\n== Agregando personajes ==");
        gestor.agregar(new Personaje("Alvaro", 120, 25, 15, 3));
        gestor.agregar(new Personaje("Bea", 90, 30, 10, 2));

        System.out.println("\n== Lista después de agregar ==");
        gestor.mostrar();

        System.out.println("\n== Modificando a Bea ==");
        gestor.modificar("Bea", 100, 40, 20, 3);

        System.out.println("\n== Lista después de modificar ==");
        gestor.mostrar();

        System.out.println("\n== Borrando a Alvaro ==");
        gestor.borrar("Alvaro");

        System.out.println("\n== Lista final ==");
        gestor.mostrar();
    }
}
