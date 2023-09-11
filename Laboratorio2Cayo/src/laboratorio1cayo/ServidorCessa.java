/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1cayo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ServidorCessa {
    
    public static void main(String[] args) {
           try {
               CessaImp cessa=new CessaImp();
               
               Naming.bind("Cessa",cessa);
           } catch (RemoteException ex) {
               Logger.getLogger(ServidorCessa.class.getName()).log(Level.SEVERE, null, ex);
           } catch (AlreadyBoundException ex) {
               Logger.getLogger(ServidorCessa.class.getName()).log(Level.SEVERE, null, ex);
           } catch (MalformedURLException ex) {
               Logger.getLogger(ServidorCessa.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       
       }
    
}
