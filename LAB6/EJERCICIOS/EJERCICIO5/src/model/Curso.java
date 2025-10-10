package model;

public class Curso {
    private int id;
    private String nombre;
    private int creditos;

    public Curso(int id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " (" + creditos + " créditos)";
    }
}
