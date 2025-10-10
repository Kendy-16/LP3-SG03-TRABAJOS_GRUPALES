package controller;

import model.*;
import view.Vista;
import java.util.List;

public class Controlador {
    private Estudiante estudiante;
    private List<Curso> cursosDisponibles;
    private Vista vista;

    public Controlador(Estudiante estudiante, List<Curso> cursosDisponibles, Vista vista) {
        this.estudiante = estudiante;
        this.cursosDisponibles = cursosDisponibles;
        this.vista = vista;
    }

    public void matricular(int idCurso) {
        try {
            Curso cursoSeleccionado = buscarCursoPorId(idCurso);
            if (cursoSeleccionado == null) {
                throw new ExcepcionMatricula("Curso con ID " + idCurso + " no encontrado.");
            }

            Matricula m = new Matricula(cursoSeleccionado, EstadoMatricula.EN_CURSO);
            estudiante.agregarMatricula(m);
            vista.mostrarMensaje("Matrícula realizada en el curso: " + cursoSeleccionado.getNombre());

        } catch (ExcepcionMatricula e) {
            vista.mostrarError(e.getMessage());
        } catch (Exception e) {
            vista.mostrarError("Ocurrió un error inesperado al matricular: " + e.getMessage());
        }
    }

    public void cambiarEstado(int idCurso, EstadoMatricula nuevoEstado) {
        try {
            Matricula matricula = buscarMatriculaPorCurso(idCurso);
            if (matricula == null) {
                throw new ExcepcionMatricula("No estás matriculado en el curso con ID " + idCurso);
            }
            matricula.setEstado(nuevoEstado);
            vista.mostrarMensaje("Estado actualizado: " + matricula.getCurso().getNombre() + " -> " + nuevoEstado);

        } catch (ExcepcionMatricula e) {
            vista.mostrarError(e.getMessage());
        } catch (Exception e) {
            vista.mostrarError("Error al cambiar el estado: " + e.getMessage());
        }
    }

    public void generarReporte() {
        vista.mostrarMensaje("\nReporte de matrículas de " + estudiante.getNombreCompleto());
        int creditosAprobados = 0;

        for (EstadoMatricula estado : EstadoMatricula.values()) {
            vista.mostrarMensaje("\n" + estado);
            for (Matricula m : estudiante.getMatriculas()) {
                if (m.getEstado() == estado) {
                    vista.mostrarMensaje(" - " + m.getCurso().getNombre() + " (" + m.getCurso().getCreditos() + " créditos)");
                    if (estado == EstadoMatricula.APROBADO) {
                        creditosAprobados += m.getCurso().getCreditos();
                    }
                }
            }
        }

        vista.mostrarMensaje("\nCréditos aprobados: " + creditosAprobados);
    }

    public void mostrarCursosDisponibles() {
        vista.mostrarCursos(cursosDisponibles);
    }

    // Métodos auxiliares (Responsabilidad única)
    private Curso buscarCursoPorId(int id) {
        return cursosDisponibles.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private Matricula buscarMatriculaPorCurso(int idCurso) {
        return estudiante.getMatriculas().stream()
                .filter(m -> m.getCurso().getId() == idCurso)
                .findFirst()
                .orElse(null);
    }
}
