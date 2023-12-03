package dao;

import db.ConexionBD;
import entity.Incidente;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IncidenteDAO {

    private Connection conexion;

    public IncidenteDAO() {
        try {
            this.conexion = ConexionBD.obtenerConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarIncidente(Incidente incidente) {
        String insercion = "INSERT INTO incidente (id_cliente, descripcion_problema, tipo_problema, id_tecnico_asignado, estado, fecha_resolucion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(insercion)) {
            ps.setInt(1, incidente.getCliente().getIdCliente());
            ps.setString(2, incidente.getDescripcionProblema());
            ps.setString(3, incidente.getTipoProblema());
            ps.setInt(4, incidente.getTecnicoAsignado().getIdTecnico());
            ps.setString(5, incidente.getEstado());
            ps.setTimestamp(6, Timestamp.valueOf(incidente.getFechaResolucion()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Incidente> obtenerIncidentesPorTecnico(int idTecnico) {
        List<Incidente> incidentes = new ArrayList<>();
        String consulta = "SELECT * FROM incidente WHERE id_tecnico_asignado = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, idTecnico);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Incidente incidente = new Incidente();
                incidente.setIdIncidente(rs.getInt("id_incidente"));
                incidente.setDescripcionProblema(rs.getString("descripcion_problema"));
                incidente.setTipoProblema(rs.getString("tipo_problema"));
                incidente.setEstado(rs.getString("estado"));

                Timestamp timestamp = rs.getTimestamp("fecha_resolucion");
                LocalDateTime fechaResolucion = timestamp.toLocalDateTime();
                incidente.setFechaResolucion(fechaResolucion);
                incidentes.add(incidente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidentes;
    }

    public void actualizarIncidente(Incidente incidente) {
        String actualizacion = "UPDATE incidente SET estado = ?, fecha_resolucion = ? WHERE id_incidente = ?";
        try (PreparedStatement ps = conexion.prepareStatement(actualizacion)) {
            ps.setString(1, incidente.getEstado());
            ps.setTimestamp(2, Timestamp.valueOf(incidente.getFechaResolucion()));
            ps.setInt(3, incidente.getIdIncidente());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

