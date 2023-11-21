import actividades.Alumno;
import actividades.Materia;

public class Main {
    public static void main(String[] args) {
        // Creación de las materias
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia sistemas = new Materia("Diseño de Sistemas");

        // Establecimiento de las correlativas
        paradigmas.agregarCorrelativa(algoritmos);
        sistemas.agregarCorrelativa(paradigmas);

        // Creación de los alumnos
        Alumno alumno1 = new Alumno("Juan", "A001");
        Alumno alumno2 = new Alumno("María", "A002");

        // Inscripción de los alumnos en las materias
        alumno1.inscribirEnMateria(algoritmos); // Intenta inscribirse en Algoritmos (no cumple con las correlativas)
        alumno1.inscribirEnMateria(paradigmas); // Intenta inscribirse en Paradigmas (cumple con las correlativas)
        alumno2.inscribirEnMateria(sistemas); // Intenta inscribirse en Diseño de Sistemas (no cumple con las correlativas)
    }
}