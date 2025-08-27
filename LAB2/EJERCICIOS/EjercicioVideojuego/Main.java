import java.util.Scanner;
import java.util.Vector;

public class Main {
    private static Vector<PersonajeBase> personajes = new Vector<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n======== MENU PRINCIPAL ========");
            System.out.println("1. Crear personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Pelea (ataque normal)");
            System.out.println("4. Usar habilidad");
            System.out.println("5. Agregar objeto a inventario");
            System.out.println("6. Ver inventario");
            System.out.println("7. Ver contador global");
            System.out.println("0. Salir");
            System.out.println("================================");
            System.out.print("Opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> crearPersonaje();
                case 2 -> mostrarPersonajes();
                case 3 -> pelear(false);
                case 4 -> pelear(true);
                case 5 -> agregarObjeto();
                case 6 -> verInventario();
                case 7 -> System.out.println("Total personajes creados: " + PersonajeBase.getContadorPersonajes());
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearPersonaje() {
        System.out.println("Elija tipo: 1) Guerrero  2) Mago  3) Arquero");
        int tipo = leerEntero();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        PersonajeBase p = switch (tipo) {
            case 1 -> new Guerrero(nombre);
            case 2 -> new Mago(nombre);
            case 3 -> new Arquero(nombre);
            default -> null;
        };

        if (p != null) {
            personajes.add(p);
            System.out.println("Personaje creado: " + p.getNombre());
        } else System.out.println("Tipo inválido.");
    }

    private static void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes.");
        } else {
            for (int i = 0; i < personajes.size(); i++) {
                System.out.print((i + 1) + ") ");
                personajes.get(i).mostrarInfo();
            }
        }
    }

    private static void pelear(boolean usarHabilidad) {
        if (personajes.size() < 2) {
            System.out.println("Se necesitan al menos 2 personajes.");
            return;
        }
        mostrarPersonajes();
        System.out.print("Atacante #: ");
        int a = leerEntero() - 1;
        System.out.print("Objetivo  #: ");
        int b = leerEntero() - 1;

        if (a >= 0 && b >= 0 && a < personajes.size() && b < personajes.size() && a != b) {
            PersonajeBase atacante = personajes.get(a);
            PersonajeBase objetivo = personajes.get(b);
            if (usarHabilidad) atacante.usarHabilidad(objetivo);
            else atacante.atacar(objetivo);
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void agregarObjeto() {
        if (personajes.isEmpty()) {
            System.out.println("Primero cree un personaje.");
            return;
        }
        mostrarPersonajes();
        System.out.print("Seleccione personaje #: ");
        int idx = leerEntero() - 1;
        PersonajeBase duenio = personajes.get(idx);
        if (idx >= 0 && idx < personajes.size()) {
            System.out.print("Nombre del objeto: ");
            String nombre = sc.nextLine();
            personajes.get(idx).getInventario().agregarObjeto(new Objeto(nombre), duenio);
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void verInventario() {
        if (personajes.isEmpty()) {
            System.out.println("Primero cree un personaje.");
            return;
        }
        mostrarPersonajes();
        System.out.print("Seleccione personaje #: ");
        int idx = leerEntero() - 1;
        if (idx >= 0 && idx < personajes.size()) {
            personajes.get(idx).getInventario().mostrarObjetos();
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static int leerEntero() {
        while (true) {
            try {
                String s = sc.nextLine();
                return Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}
