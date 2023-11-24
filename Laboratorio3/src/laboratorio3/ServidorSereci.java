/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ServidorSereci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println(
                    "Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String datos = fromClient.readLine();
            
            if("Walter Jhamil, Segovia Orellana, 11-02-1996".equals(datos)){
                
                toClient = new PrintStream(client.getOutputStream());
                toClient.println("Verificacion correcta");
                
            }
            else{
                toClient = new PrintStream(client.getOutputStream());
                toClient.println("Error, Fecha naciemiento no correcto");;
            }
           
        } catch (IOException ex) {
            Logger.getLogger(ServidorSereci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
