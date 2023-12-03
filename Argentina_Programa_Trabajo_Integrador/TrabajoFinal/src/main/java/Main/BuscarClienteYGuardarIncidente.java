package Main;

import dao.*;
import entity.*;
import interfaz.*;

import java.time.LocalDateTime;
import java.util.List;

public class BuscarClienteYGuardarIncidente {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        IncidenteDAO incidenteDAO = new IncidenteDAO();

        realizarReporteDeIncidente(clienteDAO, tecnicoDAO, incidenteDAO);
    }

    private static void realizarReporteDeIncidente(ClienteDAO clienteDAO, TecnicoDAO tecnicoDAO, IncidenteDAO incidenteDAO) {
        ConsolaInterfaz consola = new ConsolaInterfaz();
        consola.mostrarMensaje("*Bienvenido al Sistema de Reporte de Incidentes*");
        String cuitCliente = obtenerCuitCliente(clienteDAO);

        if (cuitCliente != null) {
            Cliente cliente = clienteDAO.obtenerClientePorCUIT(cuitCliente);

            if (cliente != null) {
                consola.mostrarMensaje("Cliente encontrado: " + cliente.getRazonSocial());

                consola.mostrarMensaje("Seleccione el servicio del cliente donde ocurrió el incidente (especialidad de tecnico):");
                String servicio = consola.leerEntrada();

                consola.mostrarMensaje("Ingrese la descripción del problema:");
                String descripcionProblema = consola.leerEntrada();

                consola.mostrarMensaje("Ingrese el tipo del problema:");
                String tipoProblema = consola.leerEntrada();

                asignarTecnicoAlIncidente(tecnicoDAO, incidenteDAO, cliente, servicio, descripcionProblema, tipoProblema);
            } else {
                consola.mostrarMensaje("Cliente no encontrado.");
                consola.mostrarMensaje("----------------------------------------------");
            }
        }
    }

    private static String obtenerCuitCliente(ClienteDAO clienteDAO) {
        ConsolaInterfaz consola = new ConsolaInterfaz();
        consola.mostrarMensaje("Ingrese el CUIT del cliente:");
        String cuitCliente = consola.leerEntrada();
        return clienteDAO.obtenerClientePorCUIT(cuitCliente) != null ? cuitCliente : null;
    }

    private static void asignarTecnicoAlIncidente(TecnicoDAO tecnicoDAO, IncidenteDAO incidenteDAO, Cliente cliente, String servicio, String descripcionProblema, String tipoProblema) {
        ConsolaInterfaz consola = new ConsolaInterfaz();
        List<Tecnico> tecnicosDisponibles = tecnicoDAO.obtenerTecnicosDisponiblesParaServicio(servicio);

        if (!tecnicosDisponibles.isEmpty()) {
            mostrarTecnicosDisponibles(tecnicosDisponibles);

            consola.mostrarMensaje("Seleccione el ID del técnico para asignar el incidente:");
            int idTecnicoAsignado =  Integer.parseInt(consola.leerEntrada());

            Tecnico tecnicoAsignado = tecnicoDAO.obtenerTecnicoPorId(idTecnicoAsignado, tecnicosDisponibles);
            if (tecnicoAsignado != null) {
                manejarComplejidadProblema(incidenteDAO, cliente, descripcionProblema, tipoProblema, tecnicoAsignado);
            } else {
                consola.mostrarMensaje("ID de técnico inválido.");
                consola.mostrarMensaje("----------------------------------------------");
            }
        } else {
            consola.mostrarMensaje("No hay técnicos disponibles para resolver este problema.");
            consola.mostrarMensaje("----------------------------------------------");
        }
    }

    private static void mostrarTecnicosDisponibles(List<Tecnico> tecnicosDisponibles) {
        ConsolaInterfaz consola = new ConsolaInterfaz();
        consola.mostrarMensaje("Técnicos disponibles para resolver el problema:");
        for (Tecnico tecnico : tecnicosDisponibles) {
            consola.mostrarMensaje("ID: " + tecnico.getIdTecnico() + ", Nombre: " + tecnico.getNombre());
        }
    }

    private static void manejarComplejidadProblema(IncidenteDAO incidenteDAO, Cliente cliente, String descripcionProblema, String tipoProblema, Tecnico tecnicoAsignado) {
        ConsolaInterfaz consola = new ConsolaInterfaz();
        consola.mostrarMensaje("¿El problema es complejo? (si/no)");
        String esComplejo = consola.leerEntrada();

        int colchonHoras = 0;
        if (esComplejo.equalsIgnoreCase("si")) {
            consola.mostrarMensaje("Ingrese el colchón de horas:");
            colchonHoras = Integer.parseInt(consola.leerEntrada());
        }
        crearIncidente(incidenteDAO, cliente, descripcionProblema, tipoProblema, tecnicoAsignado, colchonHoras, consola);
    }

    private static void crearIncidente(IncidenteDAO incidenteDAO, Cliente cliente, String descripcionProblema, String tipoProblema, Tecnico tecnicoAsignado, int colchonHoras, ConsolaInterfaz consola) {
        String estado = "Pendiente";
        LocalDateTime fechaResolucionEstimada = LocalDateTime.now().plusHours(colchonHoras);

        Incidente nuevoIncidente = new Incidente();
        nuevoIncidente.setCliente(cliente);
        nuevoIncidente.setDescripcionProblema(descripcionProblema);
        nuevoIncidente.setTipoProblema(tipoProblema);
        nuevoIncidente.setTecnicoAsignado(tecnicoAsignado);
        nuevoIncidente.setEstado(estado);
        nuevoIncidente.setFechaResolucion(fechaResolucionEstimada);

        incidenteDAO.agregarIncidente(nuevoIncidente);
        consola.mostrarMensaje("Incidente reportado con éxito.");
        consola.mostrarMensaje("----------------------------------------------");
    }
}