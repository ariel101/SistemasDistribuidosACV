/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockettcp;

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
public class ServidorTCP {

    public static void main(String[] args) {
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
            System.out.println(fromClient.readLine());
            toClient = new PrintStream(client.getOutputStream());
            
            int numero = Integer.parseInt(fromClient.readLine());
            System.out.println("Número recibido del cliente: " + numero);
            //toClient.println("Hola Mundo");
            
            // Calcular el Fibonacci utilizando la clase CalculadoraFibonacci
                long fibonacci = CalculadoraFibonacci.calcularFibonacci(numero);

                // Enviar el resultado al cliente
                toClient.println("El Fibonacci de " + numero + " es: " + fibonacci);

        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
