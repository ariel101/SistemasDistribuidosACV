/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microsistemarmi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class ServidorBancoCentral {

    public static void main(String args[]) {
        int port = 6789;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion
                        = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);

                /*System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress());
                System.out.println(" desde enl puerto remoto: "
                        + peticion.getPort());
                 */
                String fechaConsulta = new String(peticion.getData());
                //String[] comandos = cadena.split("-");
                //String rude = comandos[0];
                String response;

                // Obtener la cotización de la base de datos
                String respuesta = getCotizacion(fechaConsulta);

                // Enviar la respuesta al cliente
                DatagramPacket respuestaPacket = new DatagramPacket(respuesta.getBytes(), respuesta.length(),
                        peticion.getAddress(), peticion.getPort());
                socketUDP.send(respuestaPacket);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    private static String getCotizacion(String fechaConsulta) {

        // Establecer la conexión con la base de datos
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "tu_usuario", "tu_contrasena");
        ConexionMySQL conexionMySQL = new ConexionMySQL();

        try {
            // Establecer la conexión con la base de datos
            Connection connection = conexionMySQL.getConnection();

            // Consultar la cotización para la fecha dada
            String query = "SELECT Cotizacion FROM Cotizaciones WHERE Fecha = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, fechaConsulta);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        double cotizacion = resultSet.getDouble("Cotizacion");
                        return "exito"+"-"+ cotizacion;
                    } else {
                        return "error-no se encontró la cotización";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error-no se encontró la cotización";
        } finally {
            // Cerrar la conexión (puedes modificar la lógica según tu implementación)
            conexionMySQL.close();
        }
    }

}
