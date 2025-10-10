package view;

import model.Curso;
import java.util.List;

public class Vista {

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }

    public void mostrarCursos(List<Curso> cursos) {
        System.out.println("\n Lista de cursos disponibles:");
        for (Curso c : cursos) {
            System.out.println("ID: " + c.getId() + " | " + c.getNombre() + " | Créditos: " + c.getCreditos());
        }
    }
}

