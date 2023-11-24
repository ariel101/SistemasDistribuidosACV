/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockettcp;

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
 * @author Carlos
 */
public class ClienteTCP {
    public static void main(String[] args) {
        {
            int port = 5002;
            try {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                toServer.println("SIS-258");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese un número: ");
                int numero = scanner.nextInt();
                toServer.println(numero);

                // Recibir y mostrar el resultado del servidor
                String resultado = fromServer.readLine();
                System.out.println("El resultado del cálculo de Fibonacci es: " + resultado);

                // Cerrar la conexión
                client.close();

            } catch (IOException ex) {
                Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
