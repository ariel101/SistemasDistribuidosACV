/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package microsistemarmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ServidorReserva {
    
    public static void main(String[] args) {
           try {
               ImpServerReserva reserva=new ImpServerReserva();
              
               LocateRegistry.createRegistry(1099);
               Naming.bind("reserva",reserva);
           } catch (RemoteException ex) {
               Logger.getLogger(ServidorReserva.class.getName()).log(Level.SEVERE, null, ex);
           } catch (AlreadyBoundException ex) {
               Logger.getLogger(ServidorReserva.class.getName()).log(Level.SEVERE, null, ex);
           } catch (MalformedURLException ex) {
               Logger.getLogger(ServidorReserva.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       
       }
}
