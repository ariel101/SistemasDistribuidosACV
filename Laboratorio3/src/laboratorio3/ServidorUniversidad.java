/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio3;

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
public class ServidorUniversidad {
    
    public static void main(String[] args) {
           try {
               Universidad universidad=new Universidad();
               //Diploma diploma = new Diploma();
               LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
               Naming.bind("Universidad",universidad);
               
               
           } catch (RemoteException ex) {
               Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
           } catch (AlreadyBoundException ex) {
               Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
           } catch (MalformedURLException ex) {
               Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       
       }
    
}
