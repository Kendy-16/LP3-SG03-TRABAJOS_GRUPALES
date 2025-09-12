import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GestorContactos {
    private ArrayList<Contacto> contactos;
    private ArrayList<Categoria> categorias;
    
    public GestorContactos() {
        contactos = new ArrayList<>();
        categorias = new ArrayList<>();
        categorias.add(new Categoria("Familia", "Contactos familiares"));
        categorias.add(new Categoria("Trabajo", "Contactos laborales"));
        categorias.add(new Categoria("Amigos", "Contactos personales"));
    }
    
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    

    private boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(regex).matcher(correo).matches();
    }
    
    private void validarNoBlanco(String texto, String campo) throws ExcepcionDeBlanco {
        if (texto == null || texto.trim().isEmpty()) {
            throw new ExcepcionDeBlanco("El campo " + campo + " no puede estar vacío");
        }
    }
    
    public void agregarContacto(Contacto nuevo) throws ExcepcionDeBlanco, ExcepcionFormatoCorreo {
        validarNoBlanco(nuevo.getNombre(), "nombre");
        validarNoBlanco(nuevo.getCorreo(), "correo");
        
        if (!validarCorreo(nuevo.getCorreo())) {
            throw new ExcepcionFormatoCorreo();
        }
        
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nuevo.getNombre()) || 
                c.getFono() == nuevo.getFono() || 
                c.getCorreo().equalsIgnoreCase(nuevo.getCorreo())) {
                System.out.println("Advertencia: Ya existe un contacto con información similar.");
            }
        }
        
        contactos.add(nuevo);
        System.out.println("Se agregó nuevo Contacto " + nuevo.getNombre() + " con éxito");
    }
    
    public void modificarContacto(String nombre, Contacto nuevo) throws ExcepcionDeBlanco, ExcepcionFormatoCorreo {
        validarNoBlanco(nuevo.getNombre(), "nombre");
        validarNoBlanco(nuevo.getCorreo(), "correo");
        
        if (!validarCorreo(nuevo.getCorreo())) {
            throw new ExcepcionFormatoCorreo();
        }
        
        boolean encontrado = false;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                contactos.set(i, nuevo);
                encontrado = true;
                System.out.println("Contacto " + nombre + " modificado con éxito");
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontró el contacto " + nombre);
        }
    }
    
    public void eliminarContacto(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(i);
                encontrado = true;
                System.out.println("Contacto " + nombre + " eliminado con éxito");
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontró el contacto " + nombre);
        }
    }
    
    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
    
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la lista");
            return;
        }
        
        System.out.println("\n_________ LISTA DE CONTACTOS ___________");
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i+1) + ". " + contactos.get(i));
        }
    }
    
    public void agregarCategoria(Categoria categoria) throws ExcepcionDeBlanco {
        validarNoBlanco(categoria.getNombre(), "nombre de categoría");
        categorias.add(categoria);
        System.out.println("Categoría " + categoria.getNombre() + " agregada con éxito");
    }
    
    public void listarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías en la lista");
            return;
        }
        
        System.out.println("\n____________ CATEGORÍAS DISPONIBLES ____________");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i+1) + ". " + categorias.get(i));
        }
    }
}
