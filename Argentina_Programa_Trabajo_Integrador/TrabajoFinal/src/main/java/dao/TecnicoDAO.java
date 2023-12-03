package dao;

import db.ConexionBD;
import entity.Tecnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TecnicoDAO {

    private Connection conexion;

    public TecnicoDAO() {
        try {
            this.conexion = ConexionBD.obtenerConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tecnico> obtenerTecnicosDisponiblesParaServicio(String servicio) {
        List<Tecnico> tecnicosDisponibles = new ArrayList<>();
        String consulta = "SELECT * FROM tecnico WHERE especialidades LIKE ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, "%" + servicio + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tecnico tecnico = new Tecnico();
                tecnico.setIdTecnico(rs.getInt("id_tecnico"));
                tecnico.setNombre(rs.getString("nombre"));

                tecnicosDisponibles.add(tecnico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tecnicosDisponibles;
    }

    public List<Tecnico> obtenerTecnicosPorEspecialidad(String especialidad) {
        List<Tecnico> tecnicosPorEspecialidad = new ArrayList<>();
        String consulta = "SELECT * FROM tecnico WHERE especialidades LIKE ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, "%" + especialidad + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tecnico tecnico = new Tecnico();
                tecnico.setIdTecnico(rs.getInt("id_tecnico"));
                tecnico.setNombre(rs.getString("nombre"));

                tecnicosPorEspecialidad.add(tecnico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tecnicosPorEspecialidad;
    }

    public List<Tecnico> obtenerTodosLosTecnicos() {
        List<Tecnico> todosLosTecnicos = new ArrayList<>();
        String consulta = "SELECT * FROM tecnico";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tecnico tecnico = new Tecnico();
                tecnico.setIdTecnico(rs.getInt("id_tecnico"));
                tecnico.setNombre(rs.getString("nombre"));

                todosLosTecnicos.add(tecnico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todosLosTecnicos;
    }

    public Tecnico obtenerTecnicoPorId(int idTecnico, List<Tecnico> tecnicosDisponibles) {
        for (Tecnico tecnico : tecnicosDisponibles) {
            if (tecnico.getIdTecnico() == idTecnico) {
                return tecnico;
            }
        }
        return null;
    }

}

