/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sockets_mayormenor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Cliente {

    public static void main(String[] args) {
        
            int port = 5002;
            Scanner scanner = new Scanner(System.in);
            try {
                while(true){
                    
                    Socket client = new Socket("localhost", port);
                    PrintStream toServer = new PrintStream(client.getOutputStream());
                    BufferedReader fromServer = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));
                

                    System.out.println("introducir primer numero");
                    String num1 = scanner.next();
                    System.out.println("introducir segundo numero");
                    String num2 = scanner.next();
                    System.out.println("introducir tercer numero");
                    String num3 = scanner.next();

                    System.out.println("operaciones");
                    String ope = scanner.next();
                    String cadena = (ope+"-"+num1+"-"+num2+"-"+num3);
                    toServer.println(cadena);

                    /*
                    toServer.println(num1);
                    toServer.println(num2);
                    toServer.println(num3);
                    toServer.println(ope);
                    */
                    String respuesta = fromServer.readLine();
                    System.out.println(respuesta);
                    
                    if (respuesta != null && respuesta.contains("terminado")) {
                    break; // Finaliza la ejecución del cliente cuando recibe "terminado".
                }

                    
                    
                    client.close();
                    
                    
                } 
                               

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
                    

    }
    
    
}
