package model;

import controller.Controlador;
import view.Vista;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso c1 = new Curso(1, "Matemática", 4);
        Curso c2 = new Curso(2, "Programación", 3);
        Curso c3 = new Curso(3, "Base de Datos", 3);
        Curso c4 = new Curso(4, "Redes", 2);

        List<Curso> cursosDisponibles = new ArrayList<>();
        cursosDisponibles.add(c1);
        cursosDisponibles.add(c2);
        cursosDisponibles.add(c3);
        cursosDisponibles.add(c4);

        Estudiante est = new Estudiante(1, "Alexander", "Chipana");
        Vista vista = new Vista();
        Controlador ctrl = new Controlador(est, cursosDisponibles, vista);

        ctrl.mostrarCursosDisponibles();
        ctrl.matricular(1);
        ctrl.matricular(2);
        ctrl.matricular(4);
        ctrl.matricular(99); 

        ctrl.cambiarEstado(1, EstadoMatricula.APROBADO);
        ctrl.cambiarEstado(2, EstadoMatricula.DESAPROBADO);
        ctrl.cambiarEstado(3, EstadoMatricula.EN_CURSO);  
        ctrl.cambiarEstado(4, EstadoMatricula.RETIRADO);

        ctrl.generarReporte();
    }
}
