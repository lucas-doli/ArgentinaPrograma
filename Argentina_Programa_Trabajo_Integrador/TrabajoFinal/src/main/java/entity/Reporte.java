package entity;

import lombok.Data;
import java.util.List;

@Data
public class Reporte {

    private int idReporte;
    private Tecnico tecnico;
    private List<Incidente> incidentesAsignados;
    private String estadoIncidentes;

}
