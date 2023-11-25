/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package microsistemarmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            // TODO code application logic here
            IServidorReserva reserva;

            reserva = (IServidorReserva) Naming.lookup("rmi://localhost/reserva"); // instanciar un objeto remoto
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            Date fechaInicio = dateFormat.parse("12-12-2020");
            Date fechaFin = dateFormat.parse("12-12-2021");
            Date fechaCotizacion = dateFormat.parse("11-12-2020");
            System.out.println(reserva.Cotizar(fechaInicio,fechaFin,fechaCotizacion));
        } catch (NotBoundException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
