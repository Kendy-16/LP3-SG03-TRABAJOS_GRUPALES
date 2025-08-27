import java.util.Vector;

public class Inventario {
    private Vector<Objeto> objetos = new Vector<>();

    public void agregarObjeto(Objeto obj, PersonajeBase dueño) {
        objetos.add(obj);
        System.out.println(obj.getNombre() + " añadido al inventario.");
        dueño.ganarExp(10); // cada objeto da 10 EXP
    }

    public void mostrarObjetos() {
        if (objetos.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            System.out.println("Objetos:");
            for (int i = 0; i < objetos.size(); i++) {
                System.out.println("- " + objetos.get(i).getNombre());
            }
        }
    }
}
