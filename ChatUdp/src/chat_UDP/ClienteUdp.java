/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat_UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author LENOVO
 */
public class ClienteUdp {
    
    
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress direccionIP = InetAddress.getByName("localhost");
        int puerto = 12345;

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingresa tu nombre: ");
        String nombre = lector.readLine();

        byte[] datosEnvio = nombre.getBytes();
        DatagramPacket paquete = new DatagramPacket(datosEnvio, datosEnvio.length, direccionIP, puerto);

        socket.send(paquete);

        byte[] datosRecepcion = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(datosRecepcion, datosRecepcion.length);
        socket.receive(paqueteRecibido);

        String nombreReceptor = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
        System.out.println("Nombre del receptor: " + nombreReceptor);

        socket.close();
    }

    /**
     * @param args the command line arguments
     */
    
    
}
