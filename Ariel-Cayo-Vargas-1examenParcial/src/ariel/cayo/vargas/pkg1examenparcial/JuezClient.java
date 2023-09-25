/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ariel.cayo.vargas.pkg1examenparcial;

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
public class JuezClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IAsfi banco;
        try {

            banco = (IAsfi) Naming.lookup("rmi://localhost/Banco"); // instanciar un objeto remoto
            
            //System.out.println(banco.Pagar(factura2));
            
            // TODO code application logic here
        } catch (NotBoundException ex) {
            Logger.getLogger(JuezClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(JuezClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(JuezClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
