package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/trabajo_final";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Es un método público y estático (static) que devuelve un objeto Connection.
     * */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);  // DriverManager.getConnection() es un método estático que intenta establecer una conexión con la base de datos.
    }

}
