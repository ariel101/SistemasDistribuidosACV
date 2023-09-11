/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio1cayo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ClienteBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         IservidorBanco banco;
        try {

            banco = (IservidorBanco) Naming.lookup("rmi://localhost/Banco"); // instanciar un objeto remoto
            Factura[] factura1=banco.calcular(1);
            for (Factura f:factura1)
            {
                System.out.println(f);
            }
            //System.out.println(banco.Pagar(factura1));
            Factura[] factura2=banco.calcular(2);
            for (Factura f:factura2)
            {
                System.out.println(f);
            }
            
            // Realizar el pago para las facturas del cliente 1
            String resultadoPago1 = banco.pagar(factura1);
            System.out.println("Resultado del pago para el cliente 1:");
            System.out.println(resultadoPago1);

            

            // Realizar el pago para las facturas del cliente 2
            String resultadoPago2 = banco.pagar(factura2);
            System.out.println("\nResultado del pago para el cliente 2:");
            System.out.println(resultadoPago2);
            //System.out.println(banco.Pagar(factura2));
            
            // TODO code application logic here
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
