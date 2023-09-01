/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets_mayormenor;

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
 * @author Carlos
 */
public class Servidor {

    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        try {
            
                server = new ServerSocket(port);
                System.out.println( "Se inicio el servidor con éxito");
            
            while(true){
                
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");

                String cadena = fromClient.readLine();
                String[] elementos = cadena.split("-");

                System.out.println(cadena);

                System.out.println(elementos[2]);

                /*String valor1 = elementos[0];
                String valor2 = elementos[1];
                String valor3 = elementos[2];
                String valor4 = elementos[3];*/


                int num1 = Integer.parseInt(elementos[1]);
                int num2 = Integer.parseInt(elementos[2]);
                int num3 = Integer.parseInt(elementos[3]);


                //Operaciones oper = new Operaciones(num1,num2,num3);

                if("mayor".equals(elementos[0])){

                    Operaciones opera = new Operaciones(num1,num2,num3);
                    toClient = new PrintStream(client.getOutputStream());
                    toClient.println("El mayor es:"+opera.mayor());

                }
                if("menor".equals(elementos[0])){

                    Operaciones opera = new Operaciones(num1,num2,num3);
                    toClient = new PrintStream(client.getOutputStream());
                    toClient.println("El menor es:"+opera.menor());
                }
                if("salir".equals(elementos[0])){
                    
                    toClient = new PrintStream(client.getOutputStream());
                    toClient.println("terminado");
                    
                    System.exit(0);
                    
                }
                
            }
            
            
            
            //System.out.println(fromClient.readLine());
            //toClient = new PrintStream(client.getOutputStream());
            //toClient.println("Hola Mundo");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
