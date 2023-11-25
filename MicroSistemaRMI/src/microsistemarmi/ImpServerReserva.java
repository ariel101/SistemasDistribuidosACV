/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microsistemarmi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ImpServerReserva extends UnicastRemoteObject implements IServidorReserva {
    
    public ImpServerReserva() throws RemoteException{
        super();
    }

    @Override
    public double Cotizar(Date inicio, Date fin, Date fechaCotizacion) throws RemoteException {
        
        double precioBolivianos=0;
        Map<String, Double> precios = new HashMap<>();
        
        precios.put("02-12-23", 32.0);
        precios.put("03-12-23", 26.0);
        precios.put("04-12-23", 24.0);
        
        Date fechaInicio = inicio;
        Date fechaFin = fin;
        String fechaCoti = fechaCotizacion.toString();
        
        //Double precioDolares = precios.get(fechaCotizacion);
        
        
         int puerto = 6789;

        try {
            //String rude = nombres.substring(0, 2)+primer_apellido.substring(0,2)+segundo_apellido.substring(0, 2)+fecha_nacimiento.replace("-","");
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = fechaCoti.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket fecha
                    = new DatagramPacket(mensaje, fechaCoti.length(), hostServidor,
                            puerto);

            // Enviamos el datagrama
            socketUDP.send(fecha);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            String resBancoCentral = new String(respuesta.getData());
            //System.out.println(respuestaSeduca);
            double cot = Double.parseDouble(resBancoCentral);
            
            Double precioDolares = precios.get(fechaCotizacion);
            precioBolivianos = precioDolares * cot;

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        
        return precioBolivianos;
    }

    @Override
    public String Reservar(Date inicio, Date fin, int idCliente, Date fechaCompra) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
