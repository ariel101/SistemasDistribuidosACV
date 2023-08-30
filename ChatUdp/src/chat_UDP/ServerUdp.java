/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class ServerUdp {
    
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);

        byte[] datosRecepcion = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(datosRecepcion, datosRecepcion.length);
        socket.receive(paqueteRecibido);

        String nombreEmisor = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
        System.out.println("Nombre del emisor: " + nombreEmisor);

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingresa tu nombre: ");
        String nombre = lector.readLine();

        InetAddress direccionIP = paqueteRecibido.getAddress();
        int puerto = paqueteRecibido.getPort();
        byte[] datosEnvio = nombre.getBytes();
        DatagramPacket paquete = new DatagramPacket(datosEnvio, datosEnvio.length, direccionIP, puerto);

        socket.send(paquete);

        socket.close();
    }
    
}
