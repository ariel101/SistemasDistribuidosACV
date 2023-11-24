/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Universidad extends UnicastRemoteObject implements IUniversidad{

    public Universidad() throws RemoteException {
        super();
    }

    @Override
    public Diploma emitirDiploma(String ci, String nombres, String primer_apellido, String segundo_apellido, String fecha_nacimiento, String carrera) throws RemoteException {
        Diploma aux = null;
        // Llamar a SEGIP ---- RMI ---------------------------------
        try {
            
            ISegip segip;
            String apellidos = primer_apellido + " " + segundo_apellido;
            segip = (ISegip) Naming.lookup("rmi://localhost/Segip"); // instanciar un objeto remoto
            Respuesta respuesta = segip.verificar("1234532", "hodewf", "ffasdasd");

        } catch (NotBoundException ex) {
            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ------------------------------------------------

        // llamada a SEDUCA UDP ----------------------------------------
        int puerto = 6789;

        try {
            String rude = nombres.substring(0, 2)+primer_apellido.substring(0,2)+segundo_apellido.substring(0, 2)+fecha_nacimiento.replace("-","");
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = rude.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, rude.length(), hostServidor,
                            puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            String respuestaSeduca = new String(respuesta.getData());
            System.out.println(respuestaSeduca);

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        
        
        
        int port = 5002;
            try {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                toServer.println("Walter Jhamil, Segovia Orellana, 11-02-1996");
                String result = fromServer.readLine();
                System.out.println("cadena devuelta es: " + result);

            } catch (IOException ex) {
                Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return aux;
    }
    
    
    
    
}
