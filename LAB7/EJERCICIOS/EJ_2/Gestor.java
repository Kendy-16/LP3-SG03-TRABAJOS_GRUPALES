import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gestor {
    private ArrayList<Personaje> lista = new ArrayList<>();
    private String nombreArchivo = "personajes.txt";
    private File archivo = new File(nombreArchivo);

    public Gestor() {
        cargarDesdeArchivo();
    }

    // Cargar personajes desde archivo
    private void cargarDesdeArchivo() {
        lista.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 5) {
                    String nombre = partes[0];
                    int vida = Integer.parseInt(partes[1]);
                    int ataque = Integer.parseInt(partes[2]);
                    int defensa = Integer.parseInt(partes[3]);
                    int alcance = Integer.parseInt(partes[4]);
                    lista.add(new Personaje(nombre, vida, ataque, defensa, alcance));
                }
            }
        } catch (FileNotFoundException e) {
            // si el archivo no existe, no hace nada (se creará luego)
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Guardar personajes al archivo
    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Personaje p : lista) {
                pw.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Agregar personaje (si no existe)
    public void agregar(Personaje p) {
        for (Personaje per : lista) {
            if (per.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        lista.add(p);
        guardarEnArchivo();
        System.out.println("Personaje agregado correctamente.");
    }

    // Mostrar todos los personajes
    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        
        System.out.println("\n== Lista de Personajes ==");
        System.out.println("Nombre|Vida|Ataque|Defensa|Alcance");
        for (Personaje p : lista) {
            System.out.println(p.toString());
        }
    }

    // Borrar personaje por nombre
    public void borrar(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
                lista.remove(i);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            guardarEnArchivo();
            System.out.println("Personaje borrado correctamente.");
        } else {
            System.out.println("No se encontró el personaje.");
        }
    }

    // Modificar personaje por nombre
    public void modificar(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardarEnArchivo();
                System.out.println("Personaje modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el personaje.");
    }
    
    public void mostrarVida() {
        if (lista.isEmpty()) {
            System.out.println("No hay personajes para ordenar.");
            return;
        }

        ArrayList<Personaje> listaOrdenada = new ArrayList<>(lista);
        Collections.sort(listaOrdenada, Comparator.comparingInt(Personaje::getVida));

        System.out.println("\n== Personajes ordenados por vida (menor a mayor) ==");
        for (Personaje p : listaOrdenada) {
            System.out.println(p.toString());
        }
        
        System.out.print("\n¿Desea guardar este orden permanentemente? (s/n): ");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        
        if (respuesta.equalsIgnoreCase("s")) {
            lista = listaOrdenada;
            guardarEnArchivo();
            System.out.println("Orden guardado permanentemente.");
        }
    }


    public void mostrarEstadisticas() {
        if (lista.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }

        int total = lista.size();
        double sumaVida = 0; 
        double sumaAtaque = 0;
        double sumaDefensa = 0; 
        double sumaAlcance = 0;

        for (Personaje p : lista) {
            sumaVida += p.getVida();
            sumaAtaque += p.getAtaque();
            sumaDefensa += p.getDefensa();
            sumaAlcance += p.getAlcance();
        }

        double promedioVida = sumaVida / total;
        double promedioAtaque = sumaAtaque / total;
        double promedioDefensa = sumaDefensa / total;
        double promedioAlcance = sumaAlcance / total;

        System.out.println("\n== Estadísticas Generales ==");
        System.out.println("Total de personajes: " + total);
        System.out.printf("Promedio de Vida: %.2f\n", promedioVida);
        System.out.printf("Promedio de Ataque: %.2f\n", promedioAtaque);
        System.out.printf("Promedio de Defensa: %.2f\n", promedioDefensa);
        System.out.printf("Promedio de Alcance: %.2f\n", promedioAlcance);
    }    
}
