package interfaz;

import dao.IncidenteDAO;
import dao.TecnicoDAO;
import entity.Incidente;
import entity.Tecnico;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RRHH {
    private ConsolaInterfaz consola;
    private IncidenteDAO incidenteDAO;
    private TecnicoDAO tecnicoDAO;

    public RRHH() {
        this.consola = new ConsolaInterfaz();
        this.incidenteDAO = new IncidenteDAO();
        this.tecnicoDAO = new TecnicoDAO();
    }

    public void generarReporteDiario() {
        consola.mostrarMensaje("Generando reporte diario de incidentes asignados a cada técnico...");

        Map<Tecnico, List<Incidente>> incidentesPorTecnico = obtenerIncidentesPorTecnico();

        if (incidentesPorTecnico.isEmpty()) {
            consola.mostrarMensaje("No hay incidentes asignados a ningún técnico actualmente.");
        } else {
            for (Map.Entry<Tecnico, List<Incidente>> entry : incidentesPorTecnico.entrySet()) {
                consola.mostrarMensaje("Reporte para el técnico: " + entry.getKey().getNombre());
                consola.mostrarMensaje("Cantidad de incidentes: " + entry.getValue().size());
                for (Incidente incidente : entry.getValue()) {
                    consola.mostrarMensaje("ID Incidente: " + incidente.getIdIncidente() +
                            ", Descripción: " + incidente.getDescripcionProblema() +
                            ", Estado: " + incidente.getEstado());
                }
                consola.mostrarMensaje("-----");
            }
        }
    }

    private Map<Tecnico, List<Incidente>> obtenerIncidentesPorTecnico() {
        Map<Tecnico, List<Incidente>> incidentesPorTecnico = new HashMap<>();
        List<Tecnico> tecnicos = tecnicoDAO.obtenerTodosLosTecnicos();

        for (Tecnico tecnico : tecnicos) {
            List<Incidente> incidentesDelTecnico = incidenteDAO.obtenerIncidentesPorTecnico(tecnico.getIdTecnico());
            incidentesPorTecnico.put(tecnico, incidentesDelTecnico);
        }

        return incidentesPorTecnico;
    }

}

