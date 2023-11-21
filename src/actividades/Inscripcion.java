package actividades;

public class Inscripcion {
    private Materia materia;
    private boolean aprobada;

    public Inscripcion(Materia materia) {
        this.materia = materia;
        this.aprobada = false;
    }

    public Materia getMateria() {
        return materia;
    }

    public boolean aprobada() {
        return aprobada;
    }

    public void marcarAprobada() {
        this.aprobada = true;
    }
}