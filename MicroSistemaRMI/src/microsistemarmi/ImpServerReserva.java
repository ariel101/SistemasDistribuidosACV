/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microsistemarmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String[] res = resBancoCentral.split("-");
            String res1 = res[0];
            String res2 = res[1];
            System.out.println(resBancoCentral);
            double cot = Double.parseDouble(res2);
            
            Double precioDolares = precios.get(fechaCoti);
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
        
        String result = "";
        double preciototal = Cotizar(inicio, fin, fechaCompra);
        String monto = Double.toString(preciototal);
        
        String idclient = Integer.toString(idCliente);
        
        
        int port = 5002;
            try {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                toServer.println(idclient+":"+monto);
                String resu = fromServer.readLine();
                System.out.println("cadena devuelta es: " + resu);
                result=resu;

            } catch (IOException ex) {
                Logger.getLogger(ImpServerReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return result;
    }
    
}
