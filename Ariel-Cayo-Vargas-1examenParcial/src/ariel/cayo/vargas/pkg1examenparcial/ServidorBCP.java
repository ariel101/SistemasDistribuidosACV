/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ariel.cayo.vargas.pkg1examenparcial;

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
public class ServidorBCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ImpBCP BCP = new ImpBCP();
        Cuenta cuenta;
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
            
            if("Congelar:11021654-juan-perez-segovia".equals(datos)){
                
                toClient = new PrintStream(client.getOutputStream());
                toClient.println("SI-"+cuenta.getNrocuenta());
                
            }
            else{
                toClient = new PrintStream(client.getOutputStream());
                toClient.println("no existe cuenta en BCP");;
            }
           
        } catch (IOException ex) {
            Logger.getLogger(ServidorBCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
