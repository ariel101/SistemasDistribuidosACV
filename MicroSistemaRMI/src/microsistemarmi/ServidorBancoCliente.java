/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microsistemarmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ServidorBancoCliente {

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
            Map<Integer, Double> saldos = new HashMap<>();

            // Agregar datos al HashMap
            saldos.put(1, 455.0);
            saldos.put(2, 300.0);
            saldos.put(3, 1500.0);
            
            String datos = fromClient.readLine();

            String[] partes = datos.split(":");
            int idcliente = Integer.parseInt(partes[0]);
            double monto = Double.parseDouble(partes[1]);
            
            Double saldo = saldos.get(idcliente);
            
            if(saldo != null){
                
                if(saldo >= monto){
                    
                    toClient = new PrintStream(client.getOutputStream());
                    toClient.println("exito:si");
                }
                else{
                    toClient = new PrintStream(client.getOutputStream());
                    toClient.println("exito:no");
                }
                
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorBancoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
