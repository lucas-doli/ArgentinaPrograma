package dao;

import db.ConexionBD;
import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    // Se declara una variable conexion que se utilizará para almacenar una conexión a la base de datos y será accesible dentro de la clase ClienteDAO para realizar operaciones de acceso a datos.
    private Connection conexion;

    /**
     * Este constructor intenta obtener una conexión a la base de datos utilizando una clase llamada ConexionBD.
     * Si la conexión se establece correctamente, la variable conexion se inicializa con esa conexión.
     * */
    public ClienteDAO() {
        try {
            this.conexion = ConexionBD.obtenerConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método busca un cliente en la base de datos usando su número de CUIT.
     * */
    public Cliente obtenerClientePorCUIT(String cuit) {
        String consulta = "SELECT * FROM cliente WHERE CUIT = ?";  // Crea una consulta SQL parametrizada para seleccionar un cliente con un CUIT específico.

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {  // Se prepara la consulta usando un PreparedStatement (ps).
            ps.setString(1, cuit);  // Se establece el parámetro en la consulta utilizando ps.setString(1, cuit) para evitar la inyección de SQL.
            ResultSet rs = ps.executeQuery();  // El resultado de la consulta se almacena en un objeto ResultSet. Este objeto actúa como una tabla virtual de datos que contiene los resultados de la consulta SQL.

            if (rs.next()) {  // Se comprueba si hay algún resultado usando if (rs.next()). Si devuelve true, significa que se ha encontrado al menos un registro que coincide con el criterio de búsqueda.
                Cliente cliente = new Cliente();  // Se crea un objeto Cliente y se setean los datos del rs al objeto.
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setRazonSocial(rs.getString("razon_social"));
                cliente.setCUIT(rs.getString("CUIT"));

                return cliente;  // Se retorna el cliente con la información.
            }
        } catch (SQLException e) {  // Se manejan excepciones de tipo SQLException en caso de que haya problemas al ejecutar la consulta SQL o al trabajar con la base de datos.
            e.printStackTrace();
        }
        return null;  // Si no encuentra nada en base de datos, retorna null.
    }

}
