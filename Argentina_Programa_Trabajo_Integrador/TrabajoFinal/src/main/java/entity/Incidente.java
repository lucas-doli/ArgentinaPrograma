package entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Incidente {

    private int idIncidente;
    private Cliente cliente;
    private String descripcionProblema;
    private String tipoProblema;
    private Tecnico tecnicoAsignado;
    private String estado;
    private LocalDateTime fechaResolucion;

}


