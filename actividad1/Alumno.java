package actividad1;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String matricula;
    private List<Inscripcion> inscripciones;

    public Alumno(String nombre, String matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.inscripciones = new ArrayList<>();
    }

    public void inscribirEnMateria(Materia materia) {
        boolean puedeInscribirse = true;

        for (Materia correlativa : materia.getCorrelativas()) {
            if (!haAprobadoMateria(correlativa)) {
                puedeInscribirse = false;
                System.out.println("Hola " + nombre +", No puedes inscribirte en " + materia.getNombre() + ". No has aprobado todas las correlativas.");
                break;
            }
        }

        if (puedeInscribirse) {
            Inscripcion inscripcion = new Inscripcion(materia);
            inscripciones.add(inscripcion);
            System.out.println("Bienvenido " + nombre + "! Inscripción exitosa en " + materia.getNombre() +".");
        } else {

        }
    }

    private boolean haAprobadoMateria(Materia materia) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getMateria().equals(materia) && inscripcion.aprobada()) {
                return true;
            }
        }
        return false;
    }
}