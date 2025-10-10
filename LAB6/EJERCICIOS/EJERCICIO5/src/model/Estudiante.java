package model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private List<Matricula> matriculas;

    public Estudiante(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matriculas = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public void agregarMatricula(Matricula m) {
        matriculas.add(m);
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public int getCreditosAprobados() {
        return matriculas.stream()
                .filter(m -> m.getEstado() == EstadoMatricula.APROBADO)
                .mapToInt(m -> m.getCurso().getCreditos())
                .sum();
    }
}
