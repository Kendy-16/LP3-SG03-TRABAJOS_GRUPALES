package model;

public class Matricula {
    private Curso curso;
    private EstadoMatricula estado;

    public Matricula(Curso curso, EstadoMatricula estado) {
        this.curso = curso;
        this.estado = estado;
    }

    public Curso getCurso() { return curso; }
    public EstadoMatricula getEstado() { return estado; }
    public void setEstado(EstadoMatricula estado) { this.estado = estado; }
}
