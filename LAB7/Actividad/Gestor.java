import java.io.*;
import java.nio.file.*;

public class Gestor {
    private final Map<String, Personaje> personajes = new LinkedHashMap<>(); // mantiene orden de inserción
    private final Path archivo;

    public Gestor(String rutaArchivo) {
        this.archivo = Paths.get(rutaArchivo);
        cargarDesdeArchivo();
    }

    // Carga inicial desde archivo (si existe)
    private void cargarDesdeArchivo() {
        personajes.clear();
        if (!Files.exists(archivo)) return;
        try (BufferedReader br = Files.newBufferedReader(archivo)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] partes = linea.split("\\|");
                if (partes.length != 5) {
                    System.err.println("Línea inválida (se ignora): " + linea);
                    continue;
                }
                try {
                    String nombre = partes[0].trim();
                    int vida = Integer.parseInt(partes[1].trim());
                    int ataque = Integer.parseInt(partes[2].trim());
                    int defensa = Integer.parseInt(partes[3].trim());
                    int alcance = Integer.parseInt(partes[4].trim());
                    Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance);
                    personajes.put(nombre.toLowerCase(), p);
                } catch (NumberFormatException | IllegalArgumentException e) {
                    System.err.println("Error al parsear línea (se ignora): " + linea + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    // Guarda todos los personajes en el archivo (sobrescribir)
    private void guardarEnArchivo() {
        try {
            if (archivo.getParent() != null) Files.createDirectories(archivo.getParent());
            try (BufferedWriter bw = Files.newBufferedWriter(archivo)) {
                for (Personaje p : personajes.values()) {
                    bw.write(p.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error guardando archivo: " + e.getMessage());
        }
    }

    // Añadir personaje (si ya existe, no lo crea)
    public boolean añadir(Personaje p) {
        String key = p.getNombre().toLowerCase();
        if (personajes.containsKey(key)) {
            return false; // ya existe
        }
        personajes.put(key, p);
        guardarEnArchivo();
        return true;
    }

    // Borrar personaje por nombre (case-insensitive)
    public boolean borrarPorNombre(String nombre) {
        String key = nombre.toLowerCase();
        if (personajes.remove(key) != null) {
            guardarEnArchivo();
            return true;
        }
        return false;
    }

    // Modificar todos los atributos de un personaje existente (por nombre)
    // Retorna true si se modificó, false si no existe o valores inválidos
    public boolean modificarPorNombre(String nombre, int nuevaVida, int nuevoAtaque, int nuevaDefensa, int nuevoAlcance) {
        String key = nombre.toLowerCase();
        Personaje p = personajes.get(key);
        if (p == null) return false;
        try {
            // Usamos los setters de clase (validan > 0)
            p.setVida(nuevaVida);
            p.setAtaque(nuevoAtaque);
            p.setDefensa(nuevaDefensa);
            p.setAlcance(nuevoAlcance);
            // ya modificado en memoria -> guardar
            guardarEnArchivo();
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("Valores inválidos: " + e.getMessage());
            return false;
        }
    }

    // Obtener lista de personajes (copia para evitar modificaciones externas)
    public List<Personaje> listarPersonajes() {
        return new ArrayList<>(personajes.values());
    }

    // Buscar personaje por nombre (null si no existe)
    public Personaje buscarPorNombre(String nombre) {
        return personajes.get(nombre.toLowerCase());
    }

    // Verifica si existe
    public boolean existe(String nombre) {
        return personajes.containsKey(nombre.toLowerCase());
    }
}
