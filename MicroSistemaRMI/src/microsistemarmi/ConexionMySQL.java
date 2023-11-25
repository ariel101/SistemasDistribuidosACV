/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microsistemarmi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author LENOVO
 */
public class ConexionMySQL {
    private Connection conexion;

    public ConexionMySQL() {
        // Configuración de la conexión
        String url = "jdbc:mysql://localhost:3306/rmi-db";
        String usuario = "root";
        String contrasena = "null";

        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void close() {
        try {
            // Cerrar la conexión
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Este método main es solo para probar la conexión
        // No lo uses directamente en tu servidor UDP

        ConexionMySQL conexionMySQL = new ConexionMySQL();
        // Aquí puedes realizar operaciones con la base de datos si es necesario
        // ...

        // Cerrar la conexión al final
        conexionMySQL.close();
    }
}
